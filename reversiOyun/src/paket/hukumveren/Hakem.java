package paket.hukumveren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import paket.object.Hamle;
import paket.util.Sabitler;

public class Hakem {
	
	public Hakem(){
		
	}
	
public Hamle enIyiHamleSec(List<Hamle> hamleler){
    
	return enCokTasliHamle(hamleler, Sabitler.MEVCUT_OYUNCU);
}

public Hamle enCokTasliHamle(List<Hamle> hamleler,int renk){
	int deger=0,tempYakinlik=100;
	List<Hamle> cokTasliHamleler=new ArrayList<Hamle>();
	Hamle cokTasliHamle=null;
	Hamle oynanacakHamle=null;
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
				oynanacakHamle=koseHamle.get(i);
				}
			}else if(renk==Sabitler.SIYAH_OYUNCU){
				if(deger<koseHamle.get(i).getOynanacakDurum().getSiyahMiktar()){
				deger=koseHamle.get(i).getOynanacakDurum().getSiyahMiktar();
				oynanacakHamle=koseHamle.get(i);
				}
			}
			
		}	
	}else{
	for(int i=0;i<hamleler.size();i++){
		if(renk==Sabitler.BEYAZ_OYUNCU){
			if(deger<hamleler.get(i).getOynanacakDurum().getBeyazMiktar()){
			//çok taş yiyeceğimiz hamleyi aldık	
			deger=hamleler.get(i).getOynanacakDurum().getBeyazMiktar();
			cokTasliHamle=hamleler.get(i);
			//yine aynı miktarda taş yiyen eleman geldi ve listemize alıyoruz
			}else if(deger==hamleler.get(i).getOynanacakDurum().getBeyazMiktar()){
				cokTasliHamleler.add(hamleler.get(i));
			}
		}else if(renk==Sabitler.SIYAH_OYUNCU){
			if(deger<hamleler.get(i).getOynanacakDurum().getSiyahMiktar()){
			deger=hamleler.get(i).getOynanacakDurum().getSiyahMiktar();
			cokTasliHamle=hamleler.get(i);
			}else if(deger==hamleler.get(i).getOynanacakDurum().getSiyahMiktar()){
				cokTasliHamleler.add(hamleler.get(i));
			}
		}
		
	}
	//şimdi elimizde ya en çok sayılı tek hamle var ya da aynı çok sayılı hamleler var
	if(cokTasliHamleler.size()>0){
		//kenara en yakın olanı çek
		for(int i=0;i<cokTasliHamleler.size();i++){
			if(tempYakinlik>cokTasliHamleler.get(i).getOynanacakTas().getYakinlik()){
				tempYakinlik=cokTasliHamleler.get(i).getOynanacakTas().getYakinlik();
				oynanacakHamle=cokTasliHamleler.get(i);
			}
		}
	}else
		oynanacakHamle=cokTasliHamle;
	}
	return oynanacakHamle;
}

public Hamle guzelHamleOyna(List<Hamle> hamleler,int renk){
	Hamle karsihamle=null;
	//en avantajlı hamleyi bulmak için kullanılacak dizi
	Map<Integer,Integer> mapim=new HashMap<Integer,Integer>();
	int puan=0,temp=0,kacinciEleman=0,karsiHamlePuan=0;
	
	//başla
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
			koseHamle.get(i).karsiHamleleriHesapla();
			//karşı hamle yok ise es geç
			if(koseHamle.get(i).getKarsiHamleler().size()>0){
			karsihamle=enCokTasliHamle(koseHamle.get(i).getKarsiHamleler(),Sabitler.RAKIP_OYUNCU);
				if(Sabitler.MEVCUT_OYUNCU==Sabitler.SIYAH){
					karsiHamlePuan=karsihamle.getOynanacakDurum().getBeyazMiktar();
				}else{
					karsiHamlePuan=karsihamle.getOynanacakDurum().getSiyahMiktar();
				}
			}else{
				karsiHamlePuan=0;
			}
			if(Sabitler.MEVCUT_OYUNCU==Sabitler.SIYAH){
				//elimizdeki hamle puanı ile karşı hamlenin en yüksek puanı arasındaki fark
			    puan=koseHamle.get(i).getOynanacakDurum().getSiyahMiktar()-karsiHamlePuan;
			    mapim.put(i, Integer.parseInt(karsiHamlePuan+""+koseHamle.get(i).getOynanacakDurum().getSiyahMiktar()));
			}else{
				puan=koseHamle.get(i).getOynanacakDurum().getBeyazMiktar()-karsiHamlePuan;
				mapim.put(i, Integer.parseInt(karsiHamlePuan+""+koseHamle.get(i).getOynanacakDurum().getBeyazMiktar()));
			}
			/*if(temp<puan){
				temp=puan;
				//kacıncı elemanın en karlı olduğunu bilmemiz gerekiyor
				kacinciEleman=i;
			}*/
		}	
				
	}else{
	
	//bitir
	
	for(int i=0;i<hamleler.size();i++){
		hamleler.get(i).karsiHamleleriHesapla();
		//karşı hamle yok ise es geç
		if(hamleler.get(i).getKarsiHamleler().size()>0){
			
		karsihamle=enCokTasliHamle(hamleler.get(i).getKarsiHamleler(),Sabitler.RAKIP_OYUNCU);
		
			if(Sabitler.MEVCUT_OYUNCU==Sabitler.SIYAH){
				karsiHamlePuan=karsihamle.getOynanacakDurum().getBeyazMiktar();
			}else{
				karsiHamlePuan=karsihamle.getOynanacakDurum().getSiyahMiktar();
			}
		}else{
			karsiHamlePuan=0;
		}
		if(Sabitler.MEVCUT_OYUNCU==Sabitler.SIYAH){
			//elimizdeki hamle puanı ile karşı hamlenin en yüksek puanı arasındaki fark
		    puan=hamleler.get(i).getOynanacakDurum().getSiyahMiktar()-karsiHamlePuan;
		    mapim.put(i, Integer.parseInt(karsiHamlePuan+""+hamleler.get(i).getOynanacakDurum().getSiyahMiktar()));
		}else{
			puan=hamleler.get(i).getOynanacakDurum().getBeyazMiktar()-karsiHamlePuan;
			mapim.put(i, Integer.parseInt(karsiHamlePuan+""+hamleler.get(i).getOynanacakDurum().getBeyazMiktar()));
		}
		/*if(temp<puan){
			temp=puan;
			//kacıncı elemanın en karlı olduğunu bilmemiz gerekiyor
			kacinciEleman=i;
		}*/
	}
	}
	return hamleler.get(enYuksekHamle(mapim));
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

public int enYuksekHamle(Map<Integer,Integer> mapim){
	Entry<Integer,Integer> maxEntry = null;

	for(Entry<Integer,Integer> entry : mapim.entrySet()) {
	    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
	        maxEntry = entry;
	    }
	}
	return maxEntry.getKey();
}



}
