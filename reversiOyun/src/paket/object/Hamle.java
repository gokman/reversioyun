package paket.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import paket.service.TabloHareketImpl;
import paket.util.Sabitler;

public class Hamle {
	
       public Tahta oynanacakDurum;
       public List<Hamle> getKarsiHamleler() {
		return karsiHamleler;
	}


	public void setKarsiHamleler(List<Hamle> karsiHamleler) {
		this.karsiHamleler = karsiHamleler;
	}

	public Tas oynanacakTas;
       public List<Hamle> karsiHamleler;
       
       
	   public Tas getOynanacakTas() {
		return oynanacakTas;
	}


	public void setOynanacakTas(Tas oynanacakTas) {
		this.oynanacakTas = oynanacakTas;
	}

       
       public Hamle(Tas oyna,Tahta durum){
    	   
    	   this.oynanacakTas=oyna;
    	   this.oynanacakDurum=durum;
    	  // this.oynanmisDurum=oynanacakDurum;
    	   this.oynanacakDurum.setElement(oynanacakTas.getXkordinat(),oynanacakTas.getYkordinat(), oynanacakTas.getRenk());
    	   oyna();
    	   
       }
       
       
       public void oyna(){
    	   hatUzerindeOyna(solCaprazHatGetir());
    	   hatUzerindeOyna(sagCaprazHatGetir());
    	   hatUzerindeOyna(dikeyHatGetir());
    	   hatUzerindeOyna(yatayHatGetir());
       }
       
      public void hatUzerindeOyna(List<Tas> hat){
    	  
    	  /*hat üzerindeki diğer renk grubunu içine alan ilk ve son taşın yerini tutar
    	    örnek: X X 0 0 0 X X X
    	    geziciİlk 1, geziciSon da 5. eleman oluyor */ 
          Map<String,Integer> geziciİlk=new HashMap<String,Integer>(),geziciSon=new HashMap<String,Integer>();
    	  //oynanacak taşı oynadık
    	 // oynanacakDurum.setElement(oynanacakTas.getXkordinat(), oynanacakTas.getYkordinat(), oynanacakTas.getRenk());
    	  
  		for(int j=0;j<hat.size();j++){
  			 if(hat.get(j).getRenk()==Sabitler.BOS){
  				 if(geziciİlk.size()>0&&geziciSon.size()==0){
  					 geziciİlk.clear();
  				 }
  			 }else if(hat.get(j).getRenk()!=Sabitler.BOS&&geziciİlk.size()==0){
  				 geziciİlk.put(Sabitler.RENK, hat.get(j).getRenk());
  				 geziciİlk.put(Sabitler.KORDINAT, j);
  			 }else if(hat.get(j).getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
  					 geziciİlk.get(Sabitler.RENK)==hat.get(j).getRenk()){
  				 geziciİlk.clear();
  				 geziciİlk.put(Sabitler.RENK, hat.get(j).getRenk());
  				 geziciİlk.put(Sabitler.KORDINAT, j);
  			 }else if(hat.get(j).getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
  					 geziciİlk.get(Sabitler.RENK)!=hat.get(j).getRenk()){
  				 geziciSon.put(Sabitler.RENK, hat.get(j).getRenk());
  				 geziciSon.put(Sabitler.KORDINAT, j);
  			 }else if(hat.get(j).getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()>0&&
  					hat.get(j-1).getRenk()!=hat.get(j).getRenk()){
  				 geziciSon.clear();
  				 geziciSon.put(Sabitler.RENK, hat.get(j).getRenk());
  				 geziciSon.put(Sabitler.KORDINAT, j);
  			 }
  		  }
  		  //gezici son mevcut ise demek ki iki taşımız arasına rakip taşları koyduk
  		  if(geziciSon.size()>0){
    	  //şimdi elimizdeki hattı güncelleyeceğiz.
    	  for(int i=geziciİlk.get(Sabitler.KORDINAT)+1;i<geziciSon.get(Sabitler.KORDINAT);i++){
    		  this.oynanacakDurum.setElement(hat.get(i).getXkordinat(), hat.get(i).getYkordinat(), Sabitler.MEVCUT_OYUNCU);
    	  }
    	  	  
  		  }
      }
     
      
      public Tahta getOynanacakDurum() {
		return oynanacakDurum;
	}


	public void setOynanacakDurum(Tahta oynanacakDurum) {
		this.oynanacakDurum = oynanacakDurum;
	}


	public List<Tas> solCaprazHatGetir(){
    	  List<Tas> solCaprazHat=new ArrayList<Tas>();
    	  int geziciX=oynanacakTas.getXkordinat(),geziciY=oynanacakTas.getYkordinat();
    	  int temp=0;
    	//başlangıç noktasını belirliyoruz
    	  while (geziciX>0&&geziciY>0){
    		  if (temp==0){
    		  geziciX=oynanacakTas.getXkordinat()-1;
    		  geziciY=oynanacakTas.getYkordinat()-1;
    		  }else{
    			  geziciX=geziciX-1;
        		  geziciY=geziciY-1;
    		  }
    		  temp=temp+1;
    	  }
    	  //baştan sol çapraza doğru çıkıyoruz
    	  while(geziciX<8&&geziciY<8){
    		  solCaprazHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    		  geziciY=geziciY+1;
    	  }
    	  return solCaprazHat;
      }
      public List<Tas> sagCaprazHatGetir(){
    	  List<Tas> sagCaprazHat=new ArrayList<Tas>();
    	  int geziciX=oynanacakTas.getXkordinat(),geziciY=oynanacakTas.getYkordinat();
    	  int temp=0;
    	  //başlangıç noktasını belirliyoruz
    	  while (geziciX>0&&geziciY<7){
    		  if(temp==0){
    		      geziciX=geziciX-1;
    		      geziciY=geziciY+1;
    		  }else{
    			  geziciX=geziciX-1;
        		  geziciY=geziciY+1;
    		  }
    		  temp=temp+1;
    	  }
    	  //baştan sağ çapraza doğru çıkıyoruz
    	  while(geziciX<8&&geziciY>-1){
    		  sagCaprazHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    		  geziciY=geziciY-1;
    	  }
    	  return sagCaprazHat;
      }
      //yukarıdan aşağı doğru
      public List<Tas> dikeyHatGetir(){
    	  List<Tas> dikeyHat=new ArrayList<Tas>();
    	  int geziciX=oynanacakTas.getXkordinat(),geziciY=oynanacakTas.getYkordinat();
    	  int temp=0;
    	  while (geziciY>0){
    		  if(temp==0){
    		  geziciY=geziciY-1;
    		  }else{
    			  geziciY=geziciY-1;
    		  }
    		  temp=temp+1;
    	  }
    	//baştan aşağı doğru çıkıyoruz
    	  while(geziciY<8){
    		  dikeyHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciY=geziciY+1;
    	  }
    	  return dikeyHat;
      }
    //soldan sağa doğru
      public List<Tas> yatayHatGetir(){
    	  List<Tas> yatayHat=new ArrayList<Tas>();
    	  int geziciX=oynanacakTas.getXkordinat(),geziciY=oynanacakTas.getYkordinat();
    	  int temp=0;
    	  while (geziciX>0){
    		  if(temp==0){
    		  geziciX=geziciX-1;
    		  }else{
    			  geziciX=geziciX-1;
        		  
    		  }
    		  temp=temp+1;
    	  }
    	//soldan sağa doğru çıkıyoruz
    	  while(geziciX<8){
    		  yatayHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    	  }
    	  return yatayHat;
      }
      
      public void karsiHamleleriHesapla(){
    	  TabloHareketImpl hareketler=new TabloHareketImpl();
    	  List<Tas> oynanacakTaslar=new ArrayList<Tas>();
    	  oynanacakTaslar=hareketler.oynanacakTaslar(oynanacakDurum, Sabitler.RAKIP_OYUNCU);
    	  for(int i=0;i<oynanacakTaslar.size();i++){
          	karsiHamleler.add(i, new Hamle(oynanacakTaslar.get(i),oynanacakDurum));
          }
    	 
      }
      
}