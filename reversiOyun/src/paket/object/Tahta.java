package paket.object;

import paket.service.TabloHareketImpl;



public class Tahta {
	
	Tas dizi[][]=new Tas[8][8];
	int beyazMiktar=0;
	int siyahMiktar=0;
	TabloHareketImpl hareket;
	
	
	public Tahta(Tas[][] taslar){
		    this.dizi=taslar;
		    hareket=new TabloHareketImpl();
		    beyazMiktar=hareket.beyazSayiHesapla(taslar);
			siyahMiktar=hareket.siyahSayiHesapla(taslar);
	}
	

	public Tas getElement(int x,int y){
		
		if(x<0||y<0||x>7||y>7){
			
			return null;
			
		}else{
			
			return this.dizi[x][y];
			
		}
	}
	
public void setElement(int x,int y,int renk){
		
		this.dizi[x][y]=new Tas(x,y,renk);
	}
	
	public Tas[][] getDizi() {
		return dizi;
	}
	public void setDizi(Tas[][] dizi) {
		this.dizi = dizi;
	}
	public int getBeyazMiktar() {
		return hareket.beyazSayiHesapla(dizi);
	}
	public void setBeyazMiktar(int beyazMiktar) {
		this.beyazMiktar = beyazMiktar;
	}
	public int getSiyahMiktar() {
		return hareket.siyahSayiHesapla(dizi);
	}
	public void setSiyahMiktar(int siyahMiktar) {
		this.siyahMiktar = siyahMiktar;
	}	
	
}
