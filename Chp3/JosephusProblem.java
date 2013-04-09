//Problem: Josephus Problem
//efficiency: O(N)

import java.util.*;
import java.io.*;

public class JosephusProblem{
	public static int findJosephus(int gap, int nums){
		List<Integer> ls = new LinkedList<Integer>();
		
		//编号初始化
		for (int i=1; i<nums+1; i++) {
			ls.add(i);
		}

		int serial=0;
		while(ls.size()>1){
			serial += gap;
			if(serial >= ls.size()){
				serial-=ls.size();
			} 
			int out_num = ls.remove(serial);
			System.out.println("Number " + out_num + " out.");
		}
		return ls.get(0);

	}

	public static void main(String[] args){
		try{
			System.out.println("input the total number of players :");  
			BufferedReader bt=new BufferedReader(new InputStreamReader(System.in));  
			int nums=Integer.parseInt(bt.readLine());

			System.out.println("input the gap:");  
			int gap=Integer.parseInt(bt.readLine());
			
			System.out.println(findJosephus(gap, nums));
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}
	}
}