//program: printLots(L, P)
//desc: print Itegers in L whose indexs are in P

import java.util.*;
import java.io.*;

public class PrintLotsDemo{
	public static void main(String[] args){
		try{
			System.out.println("input the array size you wanna generate:");  
			BufferedReader bt=new BufferedReader(new InputStreamReader(System.in));  
			int n=Integer.parseInt(bt.readLine());
			ArrayList<Integer> l = new ArrayList<Integer>();
			ArrayList<Integer> p = new ArrayList<Integer>();

			Random rd = new Random();
			System.out.println("Generating Array P:");  
			for(int i=0;i<n;i++){
				p.add(rd.nextInt(30));
				l.add(rd.nextInt());
			}

			for(Integer i: p){
				System.out.print(" "+i);
			}

			System.out.println("\nprinting Itegers in L whose indexs are in P:");
			printLots(l,p);
			
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}
	}

	public static <Anytype> void printLots(List<Anytype> l, List<Anytype> p){
		Iterator<Anytype> itr = p.iterator();
		while(itr.hasNext()){
			int val = (Integer)itr.next();
			if(val< l.size() && val>=0){
				System.out.println( "index" + val +  " in L: " + l.get(val));
			}
		}

	}
}
