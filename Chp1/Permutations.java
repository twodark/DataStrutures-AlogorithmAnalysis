//递归实现显示字符串的全排列
//支持去重输出
import java.util.*;
import java.io.*;

public class Permutations{
	public static void main(String[] args){

		try{
			System.out.print("input the String you wanna permute:");  
			BufferedReader bt=new BufferedReader(new InputStreamReader(System.in));  
			String s=bt.readLine();  
			permute(s);
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}
	}

	static int cnt=0;

	public static void permute(String s){
		int num=s.length();
		char[] arrs = s.toCharArray();
		cnt=0;
		permute(arrs, 0, num-1);
		System.out.println("totally "+ cnt +" Arrangements.");
	}

	private static void permute(char[] arr, int low, int high){
		if(low==high){
			for(int i=0;i<=high;i++){
				System.out.print(arr[i]);
			}
			System.out.println();
			cnt++;
			return;
		}

		int[] inds=buildIndex(arr, low, high);

		for(int i=low; i<=high;i++){
			if (inds[i-low] ==0) {
				swap(arr, i, low);
				permute(arr, low+1,high);
				swap(arr, i, low);	
			}
		}
	}

	private static void swap(char[] arr, int index1, int index2){
		char tmp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=tmp;
	}

//建立索引，统计数组中每个元素出现的次数
	public static int[] buildIndex(char[] arr, int low, int high){
		int i=0;
		//cnt表示已经进行的赋值次数
		int cnt=0;
		int[] inds=new int[high-low+1];
		while(cnt < high-low+1){
			if(inds[i] >0){
				i++;
				continue;
			}
			//第cnt次赋值
			cnt++;
			int count=0;
			for(int j=i+1; j<high-low+1; j++){
				if(arr[low+i]==arr[low+j]){
					inds[j]=++count;
					cnt+=1;
				}
			}
			i++;
		}
		return inds;
	}

}