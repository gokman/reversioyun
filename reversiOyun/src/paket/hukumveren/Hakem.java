package paket.hukumveren;

import java.util.ArrayList;
import java.util.List;

import paket.object.Hamle;
import paket.util.Sabitler;

public class Hakem {
	
	public Hakem(){
		
	}
	
public Hamle enIyiHamleSec(List<Hamle> hamleler){
    
	return enCokTasliHamle(hamleler, Sabitler.MEVCUT_OYUNCU);
}

public Hamle enCokTasliHamle(List<Hamle> hamleler,int renk){
	int deger=0;
	Hamle hamle=null;
	List<Hamle> koseHamle=new ArrayList<Hamle>();
	for(int i=0;i<hamleler.size();i++){
		if(hamleler.get(i).getOynanacakTas().getXkordinat()==0||
				hamleler.get(i).getOynanacakTas().getXkordinat()==7||
				hamleler.get(i).getOynanacakTas().getYkordinat()==0||
				hamleler.get(i).getOynanacakTas().getYkordinat()==7){
			koseHamle.add(hamleler.get(i));
		}
	}
	//eğer köşe elemanı var ise onlar arasında dön yok ise ne kadar hamle var ise onlar içinde en çok puan getireni getir
	if(koseHamle.size()>0){
		for(int i=0;i<koseHamle.size();i++){
			if(renk==Sabitler.BEYAZ_OYUNCU){
				if(deger<koseHamle.get(i).getOynanacakDurum().getBeyazMiktar()){
				deger=koseHamle.get(i).getOynanacakDurum().getBeyazMiktar();
				hamle=koseHamle.get(i);
				}
			}else if(renk==Sabitler.SIYAH_OYUNCU){
				if(deger<koseHamle.get(i).getOynanacakDurum().getSiyahMiktar()){
				deger=koseHamle.get(i).getOynanacakDurum().getSiyahMiktar();
				hamle=koseHamle.get(i);
				}
			}
			
		}	
	}else{
	for(int i=0;i<hamleler.size();i++){
		if(renk==Sabitler.BEYAZ_OYUNCU){
			if(deger<hamleler.get(i).getOynanacakDurum().getBeyazMiktar()){
			deger=hamleler.get(i).getOynanacakDurum().getBeyazMiktar();
			hamle=hamleler.get(i);
			}
		}else if(renk==Sabitler.SIYAH_OYUNCU){
			if(deger<hamleler.get(i).getOynanacakDurum().getSiyahMiktar()){
			deger=hamleler.get(i).getOynanacakDurum().getSiyahMiktar();
			hamle=hamleler.get(i);
			}
		}
		
	}
	}
	return hamle;
}

public Hamle guzelHamleOyna(List<Hamle> hamleler,int renk){
	Hamle karsihamle=null;
	int puan=0,temp=0,kacinciEleman=0;
	for(int i=0;i<hamleler.size();i++){
		hamleler.get(i).karsiHamleleriHesapla();
		karsihamle=enCokTasliHamle(hamleler.get(i).getKarsiHamleler(),Sabitler.RAKIP_OYUNCU);
		if(Sabitler.MEVCUT_OYUNCU==Sabitler.SIYAH){
			//elimizdeki hamle puanı ile karşı hamlenin en yüksek puanı arasındaki fark
		    puan=hamleler.get(i).getOynanacakDurum().getSiyahMiktar()-karsihamle.getOynanacakDurum().getBeyazMiktar();
		}else{
			puan=hamleler.get(i).getOynanacakDurum().getBeyazMiktar()-karsihamle.getOynanacakDurum().getSiyahMiktar();
		}
		if(temp<puan){
			temp=puan;
			//kacıncı elemanın en karlı olduğunu bilmemiz gerekiyor
			kacinciEleman=i;
		}
	}
	return hamleler.get(kacinciEleman);
}

public Hamle enAzTasliHamle(List<Hamle> hamleler,int renk){
	int deger=100;
	Hamle hamle=null;
	for(int i=1;i<hamleler.size();i++){
		if(renk==Sabitler.BEYAZ_OYUNCU){
			if(deger>hamleler.get(i).getOynanacakDurum().getBeyazMiktar()){
			deger=hamleler.get(i).getOynanacakDurum().getBeyazMiktar();
			hamle=hamleler.get(i);
			}
		}else if(renk==Sabitler.SIYAH_OYUNCU){
			if(deger>hamleler.get(i).getOynanacakDurum().getSiyahMiktar()){
			deger=hamleler.get(i).getOynanacakDurum().getSiyahMiktar();
			hamle=hamleler.get(i);
			}
		}
		
	}
	return hamle;
}


}
