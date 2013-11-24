package paket.hareket;

import java.util.List;
import paket.object.Tahta;
import paket.object.Tas;

interface TahtaHareket {
	
     public int beyazSayiHesapla(Tahta tahta);
     public int siyahSayiHesapla(Tahta tahta);
     
     public int beyazPuanHesapla(Tahta tahta);
     public int siyahPuanHesapla(Tahta tahta);
     //belirtilen tahtada belirtilen renkte oynanabilecek taşları listeler
     public List<Tas> oynanacakTaslar(Tahta tahta,int renk);
     
}
