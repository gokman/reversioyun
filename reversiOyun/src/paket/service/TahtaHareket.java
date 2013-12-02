package paket.service;

import java.util.List;

import paket.object.Hamle;
import paket.object.Tahta;
import paket.object.Tas;

interface TahtaHareket {
	
     public int beyazSayiHesapla(Tas[][] taslar);
     public int siyahSayiHesapla(Tas[][] taslar);
     
     public int beyazPuanHesapla(Tahta tahta);
     public int siyahPuanHesapla(Tahta tahta);
     //belirtilen tahtada belirtilen renkte oynanabilecek taşları listeler
     public List<Tas> oynanacakTaslar(Tahta tahta,int renk);
     public boolean kontrol(int x,int y,int yon,Tahta tahta,int renk);
     
     //sunucu ile veri alışverişini doğru hale getirmek için çevirici metotlar
     //verilen kordinatın sunucuya göre çevrilmiş hali
     public String kordinatCevir(int x,int y);
     public List<Tas> kordinatListeCevir(List<String> list);
     public Tahta tahtaCevir(List<List<Integer>> sunucuTahta);
     
     public int xKordinatCevir(String stringX);
    
     
}
