//O(N)求解最大子序列问题

import java.util.*;
import java.io.*;

public class MaxSubSum2{
	
	public static void main(String[] args){
		try{
			System.out.print("input the array size you wanna generate:");  
			BufferedReader bt=new BufferedReader(new InputStreamReader(System.in));  
			int n=Integer.parseInt(bt.readLine());
			int[] arr = new int[n];
			Random rd = new Random();
			for(int i=0;i<n;i++){
				arr[i]=rd.nextInt(100)-50;
				System.out.print(arr[i] + ", ");
			}
			System.out.println();

			int max_sub_sum=findMaxSub(arr);
			System.out.print( "max sub sum is: "+max_sub_sum);
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}
	}

	public static int findMaxSub(int[] arr){
		int max_sub=0, sum_tmp=0;
		for(int i=0;i<arr.length;i++){
			sum_tmp+=arr[i];
			if(sum_tmp>max_sub){
				max_sub=sum_tmp;
			}
			if(sum_tmp<0){
				sum_tmp=0;
			}
		}
		return max_sub;
	}
}