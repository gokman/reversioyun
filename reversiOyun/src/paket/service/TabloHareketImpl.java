package paket.service;

import java.util.ArrayList;
import java.util.List;

import paket.object.Hamle;
import paket.object.Tahta;
import paket.object.Tas;
import paket.util.Sabitler;

public class TabloHareketImpl implements TahtaHareket{
	
	public TabloHareketImpl(){
		
	}

	@Override
	public int beyazSayiHesapla(Tas[][] taslar) {
		int miktar=0;
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(taslar[x][y].getRenk()==Sabitler.BEYAZ)
					miktar+=1;
			}
		}
		return miktar;
	}

	@Override
	public int siyahSayiHesapla(Tas[][] taslar) {
		int miktar=0;
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				if(taslar[x][y].getRenk()==Sabitler.SIYAH)
					miktar+=1;
			}
		}
		return miktar;
	}

	@Override
	public int beyazPuanHesapla(Tahta tahta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int siyahPuanHesapla(Tahta tahta) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	@Override
	public List<Tas> oynanacakTaslar(Tahta tahta,int renk) {
		List<Tas> oynanacakTaslar=new ArrayList<Tas>();
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				
				if(tahta.getElement(x, y).getRenk()==Sabitler.BOS){
					//yukarı bak
					if(y>1&&
							tahta.getElement(x, y-1).getRenk()!=renk&&tahta.getElement(x, y-1).getRenk()!=Sabitler.BOS){
						if(kontrol(x,y-2,Sabitler.YON_YUKARI,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sağ yukarı çapraz
					else if(x<6 && y>1 &&
							tahta.getElement(x+1, y-1).getRenk()!=renk&&tahta.getElement(x+1, y-1).getRenk()!=Sabitler.BOS){
						if(kontrol(x+2,y-2,Sabitler.YON_SAG_UST_CAPRAZ,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sağ 
					else if(x<6&&
							tahta.getElement(x+1, y).getRenk()!=renk && tahta.getElement(x+1, y).getRenk()!=Sabitler.BOS){
						if(kontrol(x+2,y,Sabitler.YON_SAG,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sağ alt çapraz
					else if(x<6&&y<6&&
							tahta.getElement(x+1, y+1).getRenk()!=renk && tahta.getElement(x+1, y+1).getRenk()!=Sabitler.BOS){
						if(kontrol(x+2,y+2,Sabitler.YON_SAG_ALT_CAPRAZ,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//aşağı
					else if(y<6&&
							tahta.getElement(x, y+1).getRenk()!=renk && tahta.getElement(x, y+1).getRenk()!=Sabitler.BOS){
						if(kontrol(x,y+2,Sabitler.YON_ASAGI,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sol alt çapraz
					else if(x>1&&y<6&&
							tahta.getElement(x-1, y+1).getRenk()!=renk && tahta.getElement(x-1, y+1).getRenk()!=Sabitler.BOS){
						if(kontrol(x-2,y+2,Sabitler.YON_SOL_ALT_CAPRAZ,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sol 
					else if(x>0&&
							tahta.getElement(x-1, y).getRenk()!=renk && tahta.getElement(x-1, y).getRenk()!=Sabitler.BOS){
						if(kontrol(x-2,y,Sabitler.YON_SOL,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
					//sol ust çapraz
					else if(x>0&&y>0&&
							tahta.getElement(x-1, y-1).getRenk()!=renk){
						if(kontrol(x-2,y-2,Sabitler.YON_SOL_UST_CAPRAZ,tahta,renk)==true){
							oynanacakTaslar.add(new Tas(x,y,renk));
						}
					}
				}
				
			}
		}
		return oynanacakTaslar;
	}
	
	public boolean kontrol(int x,int y,int yon,Tahta tahta,int renk){
		if(yon==Sabitler.YON_YUKARI){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(y>-1 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x,y-1,Sabitler.YON_YUKARI,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SAG_UST_CAPRAZ){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(y>-1 && x<8 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x+1,y-1,Sabitler.YON_SAG_UST_CAPRAZ,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SAG){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(x<8 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x+1,y,Sabitler.YON_SAG,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SAG_ALT_CAPRAZ){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(x<8 && y<8 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x+1,y+1,Sabitler.YON_SAG_ALT_CAPRAZ,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_ASAGI){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(y<8 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x,y+1,Sabitler.YON_ASAGI,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SOL_ALT_CAPRAZ){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(y<8 && x>-1 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x-1,y+1,Sabitler.YON_SOL_ALT_CAPRAZ,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SOL){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(x>-1 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x-1,y,Sabitler.YON_SOL,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}else if(yon==Sabitler.YON_SOL_UST_CAPRAZ){
			//tablo dışına çıkmadı isek
			//bir üst taraf boş değil ise
			//mevcut oyuncuya eşit değil ise yani diğer renk var ise devam
			if(x>-1 && y>-1 && tahta.getElement(x, y).getRenk()!=Sabitler.BOS){
				if(tahta.getElement(x, y).getRenk()!=renk){
					kontrol(x-1,y-1,Sabitler.YON_SOL_UST_CAPRAZ,tahta,renk);
					
				}else
					return true;
				
			}else
				return false;
		}
		
		return false;
	}

	@Override
	public String kordinatCevir(int x, int y) {
		String xx="";
		String yy="";
		if(x==0){
			xx="a";
		}else if(x==1){
			xx="b";
		}else if(x==2){
			xx="c";
		}else if(x==3){
			xx="d";
		}else if(x==4){
			xx="e";
		}else if(x==5){
			xx="f";
		}else if(x==6){
			xx="g";
		}else if(x==7){
			xx="h";
		}
		
		if(y==0){
			yy="1";
		}else if(y==1){
			yy="2";
		}else if(y==2){
			yy="3";
		}else if(y==3){
			yy="4";
		}else if(y==4){
			yy="5";
		}else if(y==5){
			yy="6";
		}else if(y==6){
			yy="7";
		}else if(y==7){
			yy="8";
		}
		
		return xx+yy;
	}
	
	@Override
	public int xKordinatCevir(String stringX) {
		int x=0;
		
		if(stringX.equals("a")){
			x=0;
		}else if(stringX.equals("b")){
			x=1;
		}else if(stringX.equals("c")){
			x=2;
		}else if(stringX.equals("d")){
			x=3;
		}else if(stringX.equals("e")){
			x=4;
		}else if(stringX.equals("f")){
			x=5;
		}else if(stringX.equals("g")){
			x=6;
		}else if(stringX.equals("h")){
			x=7;
		}
		
		
		return x;
	}

	@Override
	public Tahta tahtaCevir(List<List<Integer>> sunucuTahta) {
		Tas[][] taslar=new Tas[8][8];
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				taslar[y][x]=new Tas(x,y,sunucuTahta.get(x).get(y));
			}
			
		}
		return new Tahta(taslar);
	}

	@Override
	public List<Tas> kordinatListeCevir(List<String> list) {
		// TODO Auto-generated method stub
		List<Tas> taslar=new ArrayList<Tas>();
		
		for(int i=0;i<list.size();i++){
			
			taslar.add(i, new Tas(xKordinatCevir(list.get(i).substring(0,1)),Integer.parseInt(list.get(i).substring(1))-1,Sabitler.MEVCUT_OYUNCU));
		}
		return taslar;
	}

	
}