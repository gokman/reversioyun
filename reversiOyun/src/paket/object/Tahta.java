package paket.object;

public class Tahta {
	
	Tas dizi[][]=new Tas[8][8];
	int beyazMiktar=0;
	int siyahMiktar=0;
	int siyahPuan=0;
	
	public Tas getElement(int x,int y){
		
		if(x<0||y<0||x>7||y>7){
			
			return null;
			
		}else{
			
			return dizi[x][y];
			
		}
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
	public int getSiyahPuan() {
		return siyahPuan;
	}
	public void setSiyahPuan(int siyahPuan) {
		this.siyahPuan = siyahPuan;
	}
	public int getBeyazPuan() {
		return beyazPuan;
	}
	public void setBeyazPuan(int beyazPuan) {
		this.beyazPuan = beyazPuan;
	}
	int beyazPuan=0;
	
}
