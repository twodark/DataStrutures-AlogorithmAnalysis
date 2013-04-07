import java.util.*;

class FindKMaxFuncs{

//从N个数中选择第K大值
	public static <Anytype extends Comparable<? super Anytype>> Anytype findKMax(Anytype[] digs,int k){
		revSort(digs,k);
		
		for(int i=k;i<digs.length; i++){
			if(digs[i].compareTo(digs[k-1])>0){
				Anytype tmp=digs[i];
				digs[i]=digs[k-1];
				int j=k-2;
				
				while(j>=0 && tmp.compareTo(digs[j])>0 ){
					digs[j+1]=digs[j];
					j--;
				}
				digs[j+1]=tmp;
			}
		}

		return digs[k-1];
	}

	//采用希尔排序 逆序排列数组digits的前k个子数组
	public static <Anytype extends Comparable<? super Anytype>> void revSort(Anytype[] digits, int k){
		
		//d是希尔排序的步长
		int d = k;
		do{
			d=d/3+1;
			for(int i=d;i<k;i++){
				Anytype tmp = digits[i];
				int j=i-d;
				while(j>=0 && tmp.compareTo(digits[j])>0) {
					digits[j+d]=digits[j];
					j-=d;
				}
				digits[j+d]=tmp;
			}
		}while(d>1);

	}

}

public class SelectionProblem{
	public static void main(String[] args){
		int N = 10;
		int k=N/2;
		Random rd=new Random();
		Integer[] arr=new Integer[N];

		for (int i=0; i<N; i++ ) {
			arr[i]=new Integer(rd.nextInt(N*N));
		}

		for(int i=0;i<N;i++){
			System.out.print(arr[i]+", ");
		}

		System.out.println("\nthe K max is:" + GenericDigit.findKMax(arr, k) );
	}

}