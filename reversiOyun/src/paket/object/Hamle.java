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
       
       public void oyna(){
    	   solCaprazOyna();
    	   sagCaprazOyna();
    	   dikOyna();
    	   yatayOyna();
       }
       
      public void solCaprazOyna(){
    	  Tas solCaprazHat[];
    	  /*hat üzerindeki diğer renk grubunu içine alan ilk ve son taşın yerini tutar
    	    örnek: X X 0 0 0 X X X
    	    geziciİlk 1, geziciSon da 5. eleman oluyor */ 
    	  Map<Integer,Integer> geziciİlk=new HashMap<>(),geziciSon=new HashMap<>();
    	  //oynanacak taşı oynadık
    	  oynanacakDurum.setElement(oynanacakTas.getXkordinat(), oynanacakTas.getYkordinat(), oynanacakTas.getRenk());
    	  
    	  if(oynanacakTas.getXkordinat()<oynanacakTas.getYkordinat()){
    		  solCaprazHat=new Tas[8-Math.abs(oynanacakTas.getXkordinat()-oynanacakTas.getYkordinat())];
    		  for(int i=0;i<solCaprazHat.length;i++){
    			  solCaprazHat[i]=oynanacakDurum.getElement(i, oynanacakTas.getYkordinat()-oynanacakTas.getXkordinat());
    		  }
    		  //şimdi hattımızı inceleyip değişiklikleri yapacağız.
    		  for(int j=0;j<solCaprazHat.length;j++){
    			 if(solCaprazHat[j].getRenk()==Sabitler.BOS){
    				 
    			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()==0){
    				 geziciİlk.put(j, solCaprazHat[j].getRenk());
    			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&
    					 geziciİlk.size()>0&&solCaprazHat[j].getRenk()==geziciİlk.get(j-1)){
    				 geziciİlk.remove(j-1);
    				 geziciİlk.put(j, solCaprazHat[j].getRenk());
    			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&
    					 geziciİlk.size()>0&&solCaprazHat[j].getRenk()!=geziciİlk.get(j-1)&&geziciSon.size()==0){
    				 geziciSon.put(j, solCaprazHat[j].getRenk());
    			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&
    					 geziciSon.size()>0&&solCaprazHat[j].getRenk()!=geziciSon.get(j-1)){
    				    geziciSon.remove(j-1);
    				    geziciSon.put(j, solCaprazHat[j].getRenk());
    			 }
    		  }
    	  }else if(oynanacakTas.getXkordinat()>oynanacakTas.getYkordinat()){
    		  solCaprazHat=new Tas[8-Math.abs(oynanacakTas.getXkordinat()-oynanacakTas.getYkordinat())];
    		  for(int i=0;i<solCaprazHat.length;i++){
    			  solCaprazHat[i]=oynanacakDurum.getElement(oynanacakTas.getXkordinat()-oynanacakTas.getYkordinat(),i);
    		  }
    	  }else{
    		  solCaprazHat=new Tas[8];
    		  for(int i=0;i<solCaprazHat.length;i++){
    			  solCaprazHat[i]=oynanacakDurum.getElement(i,i);
    		  }
    	  }
    	  //şimdi elimizdeki hattı güncelleyip inceleyeceğiz.
    	  
      }
      
      public void sagCaprazOyna(){
    	  
      }
      public void dikOyna(){
    	  
      }
      public void yatayOyna(){
    	  
      }
      
}
