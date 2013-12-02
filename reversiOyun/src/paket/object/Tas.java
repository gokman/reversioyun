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
		
		public int getYakinlik(){
			int yakinlikMiktar=0;
	        //tahtayı dört bölgeye ayırıyoruz
			if(this.xkordinat<4&&this.ykordinat<4){
				if(this.xkordinat<this.ykordinat)
					yakinlikMiktar=this.xkordinat;
				else
					yakinlikMiktar=this.ykordinat;
			}else if(this.xkordinat>4&&this.ykordinat<4){
				if(7-this.xkordinat<this.ykordinat)
					yakinlikMiktar=7-this.xkordinat;
				else
					yakinlikMiktar=this.ykordinat;
			}else if(this.xkordinat>4&&this.ykordinat>4){
				if(7-this.xkordinat<7-this.ykordinat)
					yakinlikMiktar=7-this.xkordinat;
				else
					yakinlikMiktar=7-this.ykordinat;
			}else if(this.xkordinat<4&&this.ykordinat>4){
				if(this.xkordinat<7-this.ykordinat)
					yakinlikMiktar=this.xkordinat;
				else
					yakinlikMiktar=7-this.ykordinat;
			}
			return yakinlikMiktar;
		}
}
