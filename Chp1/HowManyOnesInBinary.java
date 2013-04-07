//递归查找数N的二进制表示中1的个数
import java.util.*;
import java.io.*;

public class HowManyOnesInBinary{
	public static void main(String[] args){
		try{
			System.out.println("input the integer you wanna lookup:");  
			BufferedReader bt=new BufferedReader(new InputStreamReader(System.in));  
			String s=bt.readLine();  
			long n =Long.parseLong(s);
			System.out.println(findHowManyOnes(n));
			}catch(IOException ex){
				System.out.println(ex.getMessage());  
			}catch(NumberFormatException e){
				System.out.println("invalid input. error code: "+e.getMessage());  
			}
	}
	public static int findHowManyOnes(long n){
		if(n==0){
			return 0;
		}
		if(n%2==0){
			return findHowManyOnes(n/2);
		}else{
			return findHowManyOnes(n/2)+1;
		}
	}
}