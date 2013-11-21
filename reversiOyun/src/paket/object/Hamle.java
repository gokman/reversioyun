package paket.object;

public class Hamle {
	
       Tahta oynanmisDurum;
       Tahta oynanacakDurum;
       Tas oynanacakTas;
       Renk renk;
       
       public Hamle(Tas oynanacakTas,Tahta oynanacakDurum){
    	   
    	   this.oynanacakTas=oynanacakTas;
    	   this.oynanacakDurum=oynanacakDurum;
    	   
       }
       
       public void oyna(){
    	   //bu metotta mevcut tahtaya yapılan hamle sonucunda tahtanın geçeceği durumu gösterir
    	   for(int i=0;i<kacBirimGidilecek(oynanacakTas.getXkordinat(), oynanacakTas.getYkordinat(), Yon.solUstCapraz);i++){
    		   
    	   }
    			
       }
       
       public void solUstCaprazGit(int x,int y,int gidilecekBirim,int maksimumBirim){
    	   int adim=1;
    	   if(adim<=maksimumBirim){
	    		   //gideceği yöndeki ilk taş karşı renkte olacak
	    		   if(adim==1&&
	    			  oynanacakDurum.getElement(x-adim, y-adim).getRenk()!=Renk.bos&&
	    			  oynanacakDurum.getElement(x-adim, y-adim).getRenk()!=oynanacakTas.getRenk()){
	    			   adim+=1;
	    			solUstCaprazGit(x, y, adim, maksimumBirim);   
	    		   }else{
	    			   //ilk adımı atamadı ve patladı
	    			   adim=-1;
	    		   }
    	   }
       }
       
       public int kacBirimGidilecek(int x,int y,int yon){
    	   
    	   int sonuc=0;
    	   if(yon==Yon.solUstCapraz){
    		   if(x<y)
    			   sonuc=x;
    		       sonuc=y;
    	   }else if(yon==Yon.solAltCapraz){
    		   if(x<7-y)
    			   sonuc=x;
    		       sonuc=7-y;
    	   }else if(yon==Yon.ust){
    		   		sonuc=y;
    	   }else if(yon==Yon.alt){
    		   sonuc=7-y;
    	   }else if(yon==Yon.sag){
    		   sonuc=7-x;
    	   }else if(yon==Yon.sol){
    		   sonuc=x;
    	   }else if(yon==Yon.sagAltCapraz){
    		   if(7-y<7-x)
    			   sonuc=7-y;
    		       sonuc=7-x;
    	   }else if(yon==Yon.sagUstCapraz){
    		   if(y<7-x)
    			   sonuc=y;
    		       sonuc=7-x;
    	   }
    	   return sonuc;
    	   
       }
}
