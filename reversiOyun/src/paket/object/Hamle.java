package paket.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hamle {
	
       Tahta oynanmisDurum;
       Tahta oynanacakDurum;
       Tas oynanacakTas;
       
       public Hamle(Tas oynanacakTas,Tahta oynanacakDurum){
    	   
    	   this.oynanacakTas=oynanacakTas;
    	   this.oynanacakDurum=oynanacakDurum;
    	   
       }
       
       
       public void oyna(){
    	   hatUzerindeOyna(solCaprazHatGetir());
    	   hatUzerindeOyna(sagCaprazHatGetir());
    	   hatUzerindeOyna(dikeyHatGetir());
    	   hatUzerindeOyna(yatayHatGetir());
    	   oynanmisDurum=oynanacakDurum;
       }
       
      public void hatUzerindeOyna(List<Tas> hat){
    	  
    	  /*hat üzerindeki diğer renk grubunu içine alan ilk ve son taşın yerini tutar
    	    örnek: X X 0 0 0 X X X
    	    geziciİlk 1, geziciSon da 5. eleman oluyor */ 
          Map<String,Integer> geziciİlk=new HashMap<String,Integer>(),geziciSon=new HashMap<>();
    	  //oynanacak taşı oynadık
    	 // oynanacakDurum.setElement(oynanacakTas.getXkordinat(), oynanacakTas.getYkordinat(), oynanacakTas.getRenk());
    	  
  		for(int j=0;j<hat.size();j++){
  			 if(hat.get(j).getRenk()==Sabitler.BOS){
  				 
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
    	  //şimdi elimizdeki hattı güncelleyeceğiz.
    	  for(int i=geziciİlk.get(Sabitler.KORDINAT)+1;i<geziciSon.get(Sabitler.KORDINAT);i++){
    		  oynanacakDurum.setElement(hat.get(i).getXkordinat(), hat.get(i).getYkordinat(), Sabitler.MEVCUT_OYUNCU);
    	  }
      }
     
      
      public List<Tas> solCaprazHatGetir(){
    	  List<Tas> solCaprazHat=new ArrayList<Tas>();
    	  int geziciX=-1,geziciY=-1;
    	//başlangıç noktasını belirliyoruz
    	  while (geziciX!=-1||geziciY!=-1){
    		  geziciX=oynanacakTas.getXkordinat()-1;
    		  geziciY=oynanacakTas.getYkordinat()-1;
    	  }
    	  //baştan sol çapraza doğru çıkıyoruz
    	  while(geziciX!=8||geziciY!=8){
    		  solCaprazHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    		  geziciY=geziciY+1;
    	  }
    	  return solCaprazHat;
      }
      public List<Tas> sagCaprazHatGetir(){
    	  List<Tas> sagCaprazHat=new ArrayList<Tas>();
    	  int geziciX=-1,geziciY=-1;
    	  //başlangıç noktasını belirliyoruz
    	  while (geziciX!=-1||geziciY!=8){
    		  geziciX=oynanacakTas.getXkordinat()-1;
    		  geziciY=oynanacakTas.getYkordinat()+1;
    	  }
    	  //baştan sağ çapraza doğru çıkıyoruz
    	  while(geziciX!=8||geziciY!=-1){
    		  sagCaprazHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    		  geziciY=geziciY-1;
    	  }
    	  return sagCaprazHat;
      }
      //yukarıdan aşağı doğru
      public List<Tas> dikeyHatGetir(){
    	  List<Tas> dikeyHat=new ArrayList<Tas>();
    	  int geziciX=-1,geziciY=-1;
    	  while (geziciY!=-1){
    		  geziciX=oynanacakTas.getXkordinat();
    		  geziciY=oynanacakTas.getYkordinat()-1;
    	  }
    	//baştan aşağı doğru çıkıyoruz
    	  while(geziciY!=8){
    		  dikeyHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciY=geziciY+1;
    	  }
    	  return dikeyHat;
      }
    //soldan sağa doğru
      public List<Tas> yatayHatGetir(){
    	  List<Tas> yatayHat=new ArrayList<Tas>();
    	  int geziciX=-1,geziciY=-1;
    	  while (geziciX!=-1){
    		  geziciX=oynanacakTas.getXkordinat()-1;
    		  geziciY=oynanacakTas.getYkordinat();
    	  }
    	//soldan sağa doğru çıkıyoruz
    	  while(geziciX!=8){
    		  yatayHat.add(new Tas(geziciX,geziciY,oynanacakDurum.getElement(geziciX, geziciY).getRenk()));
    		  geziciX=geziciX+1;
    	  }
    	  return yatayHat;
      }
      
}
