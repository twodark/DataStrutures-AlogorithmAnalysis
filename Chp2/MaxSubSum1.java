//分治求解最大子序列问题

import java.util.*;
import java.io.*;

public class MaxSubSum1{

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

			int max_sub_sum=maxSumRec(arr,0,arr.length-1);
			System.out.print( "max sub sum is: "+max_sub_sum);
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}
	}
	public static int maxSumRec(int[] arr ,int low, int high){
		if(low == high){
			return arr[low]>0 ? arr[low]:0;
		}

		int middle=(low+high)/2;
		int subsum1=maxSumRec(arr, low ,middle);
		int subsum2=maxSumRec(arr,middle+1,high);

		int max_left_sum=0, left_rec_sum=0;
		int max_right_sum=0, right_rec_sum=0;

		//求左边最大子序列和
		for(int i=middle; i>=low;i--){
			left_rec_sum+=arr[i];
			if(left_rec_sum > max_left_sum){
				max_left_sum=left_rec_sum;
			}
		}
		//求右边区间最大子序列和
		for(int i=middle+1; i<=high;i++){
			right_rec_sum+=arr[i];
			if(right_rec_sum > max_right_sum){
				max_right_sum=right_rec_sum;
			}
		}	
		return max(subsum1, subsum2, max_left_sum+max_right_sum);

	}

	private static int max(int v1, int v2, int v3){
		return v1>v2?(v1>v3? v1: v3):(v2>v3)?v2:v3;
	}

}