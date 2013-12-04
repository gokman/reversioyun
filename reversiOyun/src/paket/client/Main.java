package paket.client;


import paket.domain.Game;
import paket.hukumveren.Hakem;
import paket.object.Hamle;
import paket.object.Tahta;
import paket.object.Tas;
import paket.service.TabloHareketImpl;
import paket.util.Sabitler;
import paket.client.clients.GameClient;

import java.util.*;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;



public class Main {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private final Timer timer = new Timer();
    


    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public Main(final String baseAddress, final String authCode, final int player) {

        List<JacksonJsonProvider> providers  = Arrays.asList(new JacksonJsonProvider());
        GameClient                client     = JAXRSClientFactory.create(baseAddress, GameClient.class, providers);
        TimerTask                 pollerTask = new PollerTask(authCode, player, client);

        timer.scheduleAtFixedRate(pollerTask, 500, 500);
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        final String baseAddress = "http://localhost:8080/reversi-stadium/rest/";
        final String authCode    = "eota5581";
        final int    player      = Sabitler.SIYAH_OYUNCU;
        Sabitler.MEVCUT_OYUNCU=player;
        new Main(baseAddress, authCode, player);
    }



    //~ --- [INNER CLASSES] --------------------------------------------------------------------------------------------

    private class PollerTask extends TimerTask {



        //~ --- [INSTANCE FIELDS] --------------------------------------------------------------------------------------

        private final String     authCode;
        private final GameClient client;
        private final int        player;



        //~ --- [CONSTRUCTORS] -----------------------------------------------------------------------------------------

        private PollerTask(final String authCode, final int player, final GameClient client) {

            this.authCode = authCode;
            this.player   = player;
            this.client   = client;
        }



        //~ --- [METHODS] ----------------------------------------------------------------------------------------------

        @Override
        public void run() {

            Game game = client.status();

            if (game.isCancelled()) {
                timer.cancel();
            } else if (!game.isStarted()) {
                timer.cancel();
            } else if (game.getCurrentPlayer() == player) {
            	// tahtayı çek
            	Tahta anaTahta=new TabloHareketImpl().tahtaCevir(game.getBoardState());
                //oynanabilecek taşları da çek
                List<String> availableMoves = game.getAvailableMoves();
                List<Tas> oynanabilecekTaslar=new TabloHareketImpl().kordinatListeCevir(availableMoves);
                //şimdi oynayabiliriz
                //hamle listesi oluşturacağız
                List<Hamle> hamleler=new ArrayList<Hamle>();
                for(int i=0;i<oynanabilecekTaslar.size();i++){
                	hamleler.add(i, new Hamle(oynanabilecekTaslar.get(i),new TabloHareketImpl().tahtaCevir(game.getBoardState())));
                }
                //hamlelerden en iyi olanı seçeceğiz
                Hakem hakem=new Hakem();
                //Hamle enIyiHamle=hakem.enCokTasliHamle(hamleler, Sabitler.MEVCUT_OYUNCU);
                Hamle enGuzelHamle=hakem.guzelHamleOyna(hamleler, Sabitler.MEVCUT_OYUNCU);
                
               // Random       random         = new Random();
               // int          randomInt      = random.nextInt(availableMoves.size());
                String       nextMove       = new TabloHareketImpl().
                		kordinatCevir(enGuzelHamle.getOynanacakTas().getXkordinat(),
                		enGuzelHamle.getOynanacakTas().getYkordinat());

                client.move(authCode, nextMove);
            }
        }
    }
}