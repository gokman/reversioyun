package paket.object;

import java.util.HashMap;
import java.util.Map;

public class Hamle {
	
       Tahta oynanmisDurum;
       Tahta oynanacakDurum;
       Tas oynanacakTas;
       
       public Hamle(Tas oynanacakTas,Tahta oynanacakDurum){
    	   
    	   this.oynanacakTas=oynanacakTas;
    	   this.oynanacakDurum=oynanacakDurum;
    	   
       }
       
       public Hamle(){
    	   
       }
       
       public void oyna(){
    	   solCaprazOyna();
    	   sagCaprazOyna();
    	   dikOyna();
    	   yatayOyna();
       }
       
      public void solCaprazOyna(){
    	  Tas solCaprazHat[]=new Tas[8];
    	  solCaprazHat[0]=new Tas(0,0,Sabitler.SIYAH);
          solCaprazHat[1]=new Tas(1,1,Sabitler.SIYAH);
          solCaprazHat[2]=new Tas(2,2,Sabitler.BEYAZ);
          solCaprazHat[3]=new Tas(3,3,Sabitler.SIYAH);
          solCaprazHat[4]=new Tas(4,4,Sabitler.BEYAZ);
          solCaprazHat[5]=new Tas(5,5,Sabitler.SIYAH);
          solCaprazHat[6]=new Tas(6,6,Sabitler.SIYAH);
          solCaprazHat[7]=new Tas(7,7,Sabitler.SIYAH);
    	  /*hat üzerindeki diğer renk grubunu içine alan ilk ve son taşın yerini tutar
    	    örnek: X X 0 0 0 X X X
    	    geziciİlk 1, geziciSon da 5. eleman oluyor */ 
          Map<String,Integer> geziciİlk=new HashMap<String,Integer>(),geziciSon=new HashMap<>();
    	  //oynanacak taşı oynadık
    	 // oynanacakDurum.setElement(oynanacakTas.getXkordinat(), oynanacakTas.getYkordinat(), oynanacakTas.getRenk());
    	  

  		for(int j=0;j<solCaprazHat.length;j++){
  			 if(solCaprazHat[j].getRenk()==Sabitler.BOS){
  				 
  			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()==0){
  				 geziciİlk.put(Sabitler.RENK, solCaprazHat[j].getRenk());
  				 geziciİlk.put(Sabitler.KORDINAT, j);
  			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
  					 geziciİlk.get(Sabitler.RENK)==solCaprazHat[j].getRenk()){
  				 geziciİlk.clear();
  				 geziciİlk.put(Sabitler.RENK, solCaprazHat[j].getRenk());
  				 geziciİlk.put(Sabitler.KORDINAT, j);
  			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
  					 geziciİlk.get(Sabitler.RENK)!=solCaprazHat[j].getRenk()){
  				 geziciSon.put(Sabitler.RENK, solCaprazHat[j].getRenk());
  				 geziciSon.put(Sabitler.KORDINAT, j);
  			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()>0&&
  					 solCaprazHat[j-1].getRenk()!=solCaprazHat[j].getRenk()){
  				 geziciSon.clear();
  				 geziciSon.put(Sabitler.RENK, solCaprazHat[j].getRenk());
  				 geziciSon.put(Sabitler.KORDINAT, j);
  			 }
  		  }
    	  //şimdi elimizdeki hattı güncelleyeceğiz.
    	  for(int i=geziciİlk.get(Sabitler.KORDINAT)+1;i<geziciSon.get(Sabitler.KORDINAT);i++){
    		  oynanacakDurum.setElement(solCaprazHat[i].getXkordinat(), solCaprazHat[i].getYkordinat(), Sabitler.MEVCUT_OYUNCU);
    	  }
      }
      
      public void sagCaprazOyna(){
    	  
      }
      public void dikOyna(){
    	  
      }
      public void yatayOyna(){
    	  
      }
      
}
