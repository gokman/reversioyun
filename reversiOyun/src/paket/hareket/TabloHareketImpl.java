package paket.hareket;

import java.util.ArrayList;
import java.util.List;
import paket.object.Sabitler;
import paket.object.Tahta;
import paket.object.Tas;

public class TabloHareketImpl implements TahtaHareket{

	@Override
	public int beyazSayiHesapla(Tahta tahta) {
		int miktar=0;
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(tahta.getElement(x, y).getRenk()==Sabitler.BEYAZ)
					miktar+=1;
			}
		}
		return miktar;
	}

	@Override
	public int siyahSayiHesapla(Tahta tahta) {
		int miktar=0;
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(tahta.getElement(x, y).getRenk()==Sabitler.SIYAH)
					miktar+=1;
			}
		}
		return miktar;
	}

	@Override
	public int beyazPuanHesapla(Tahta tahta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int siyahPuanHesapla(Tahta tahta) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	@Override
	public List<Tas> oynanacakTaslar(Tahta tahta,int renk) {
		List<Tas> oynanacakTaslar=new ArrayList<Tas>();
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				//taş yok ise potansiyel bir oynanacak taştır bu
				if(tahta.getElement(x, y).getRenk()==Sabitler.BOS){
					//saat yönünde tüm yönlere bakacağız
					//baktığımız yönde eleman var ise ve siyah veya beyaz taş var ise o zaman taş koyulabilir
					if(!tahta.getElement(x-1, y-1).equals(null)&&
							tahta.getElement(x-1, y-1).getRenk()!=renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x, y-1).equals(null)&&
							   tahta.getElement(x, y-1).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x+1, y-1).equals(null)&&
							   tahta.getElement(x+1, y-1).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x+1, y).equals(null)&&
							   tahta.getElement(x+1, y).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x+1, y+1).equals(null)&&
							   tahta.getElement(x+1, y+1).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x, y+1).equals(null)&&
							   tahta.getElement(x, y+1).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x-1, y+1).equals(null)&&
							   tahta.getElement(x-1, y+1).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}else if(!tahta.getElement(x-1, y).equals(null)&&
							   tahta.getElement(x-1, y).getRenk()==renk){
						oynanacakTaslar.add(new Tas(x,y,tahta.getElement(x, y).getRenk()));
					}
				}
			}
		}
		return oynanacakTaslar;
	}

	

}
