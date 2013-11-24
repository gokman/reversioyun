package paket.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import paket.object.Sabitler;
import paket.object.Tas;


public class Main {
	
	public static void main(String args[]){
		
		Tas solCaprazHat[]=new Tas[7];
        solCaprazHat[0]=new Tas(1,1,Sabitler.SIYAH);
        solCaprazHat[1]=new Tas(1,1,Sabitler.BEYAZ);
        solCaprazHat[2]=new Tas(1,1,Sabitler.BEYAZ);
        solCaprazHat[3]=new Tas(1,1,Sabitler.SIYAH);
        solCaprazHat[4]=new Tas(1,1,Sabitler.SIYAH);
        solCaprazHat[5]=new Tas(1,1,Sabitler.SIYAH);
        solCaprazHat[6]=new Tas(1,1,Sabitler.SIYAH);
		Map<Integer,Integer> geziciİlk=new HashMap<Integer,Integer>(),geziciSon=new HashMap<>();
		
		
		for(int j=0;j<solCaprazHat.length;j++){
			 if(solCaprazHat[j].getRenk()==Sabitler.BOS){
				 
			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()==0){
				 geziciİlk.put(j, solCaprazHat[j].getRenk());
			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
					 geziciİlk.get(j-1)==solCaprazHat[j].getRenk()){
				 geziciİlk.clear();
				 geziciİlk.put(j, solCaprazHat[j].getRenk());
			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()==0&&
					 geziciİlk.get(j-1)!=solCaprazHat[j].getRenk()){
				 geziciSon.put(j, solCaprazHat[j].getRenk());
			 }else if(solCaprazHat[j].getRenk()!=Sabitler.BOS&&geziciİlk.size()>0&&geziciSon.size()>0&&
					 solCaprazHat[j-1].getRenk()!=solCaprazHat[j].getRenk()){
				 geziciSon.clear();
				 geziciSon.put(j, solCaprazHat[j].getRenk());
			 }
		  }
		System.out.println(geziciİlk);
		System.out.println("\n");
		System.out.println(geziciSon);
	}

}
