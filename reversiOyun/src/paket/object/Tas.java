package paket.object;

public class Tas {
		
		int xkordinat=-1;
		int ykordinat=-1;
		public int getXkordinat() {
			return xkordinat;
		}

		public void setXkordinat(int xkordinat) {
			this.xkordinat = xkordinat;
		}

		public int getYkordinat() {
			return ykordinat;
		}

		public void setYkordinat(int ykordinat) {
			this.ykordinat = ykordinat;
		}
		int renk=-1;
		
		public Tas(int xkordinat,int ykordinat,int renk){
			this.xkordinat=xkordinat;
			this.ykordinat=ykordinat;
			this.renk=renk;
		}
		
		public int getRenk() {
			return renk;
		}
		public void setRenk(int renk) {
			this.renk = renk;
		}
}
