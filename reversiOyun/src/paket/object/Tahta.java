package paket.object;

public class Tahta {
	
	Tas dizi[][]=new Tas[8][8];
	int beyazMiktar=0;
	int siyahMiktar=0;
	//karşı hamle sonucu tükenecek taşlarını kontrol eder.
	int riskMiktar=0;
	
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
		return beyazMiktar;
	}
	public void setBeyazMiktar(int beyazMiktar) {
		this.beyazMiktar = beyazMiktar;
	}
	public int getSiyahMiktar() {
		return siyahMiktar;
	}
	public void setSiyahMiktar(int siyahMiktar) {
		this.siyahMiktar = siyahMiktar;
	}
	public int getRiskMiktar() {
		return riskMiktar;
	}
	public void setRiskMiktar(int riskMiktar) {
		this.riskMiktar = riskMiktar;
	}
	
	
	
}
