//List的扩展操作
import java.util.*;

public class ListOperationExt{
	//要求交集的表已经按顺序排列好
	public static <Anytype extends Comparable> List<Anytype> intersection(List<Anytype> sorted1, List<Anytype> sorted2){
		List<Anytype> inter = new ArrayList<Anytype>();
		Anytype test_1,test_2;
		
		if(sorted1.isEmpty() || sorted2.isEmpty()){
			return inter;
		}
		int i=0, j=0;
		while(i<sorted1.size() && j< sorted2.size()){
			test_1=sorted1.get(i);
			test_2=sorted2.get(j);
			if (test_1.compareTo(test_2)==0) {
				inter.add(test_1);
				i++;
				j++;
			}else if(test_1.compareTo(test_2)>0){
				j++;
			}else{
				i++;
			}
		}
		return inter;
	}

	public static <Anytype extends Comparable> List<Anytype> union(List<Anytype> sorted1, List<Anytype> sorted2){
		List<Anytype> unn = new ArrayList<Anytype>();
		Anytype test_1,test_2;
		
		int i=0, j=0;
		while(i<sorted1.size() && j< sorted2.size()){
			test_1=sorted1.get(i);
			test_2=sorted2.get(j);
			if (test_1.compareTo(test_2)==0) {
				unn.add(test_1);
				i++;
				j++;
			}else if(test_1.compareTo(test_2)>0){
				if(unn.size()==0 || test_2.compareTo(unn.get(unn.size()-1))>0){
					unn.add(test_2);
				}
				j++;
			}else{
				if(unn.size()==0 || test_1.compareTo(unn.get(unn.size()-1))>0){
					unn.add(test_1);
				}
				i++;
			}
		}

		while(i<sorted1.size()){
			unn.add(sorted1.get(i++));
		}
		
		while(j<sorted2.size()){
			unn.add(sorted2.get(j++));
		}

		return unn;
	}

/*	public static void main(String[] args){
		List<Integer> lst1 = new LinkedList<Integer>();
		List<Integer> lst2 = new LinkedList<Integer>();

		lst1.add(0);
		for(int i=0; i<15;i++){
			lst1.add(i);
		}

		for(Integer a : lst1){
			System.out.print(a+", ");
		}

		System.out.println();

		lst2.add(0);
		for (int j=0; j<7;j++ ) {
			lst2.add(j*2+1);
		}
		lst2.add(13);
		
		for(Integer a : lst2){
			System.out.print(a+ ", ");
		}

		List<Integer> l3 = intersection(lst1,lst2);
		List<Integer> l4 = union(lst1,lst2);

		System.out.println();
		for(Integer a : l3){
			System.out.print(a+ ", ");
		}

		System.out.println();
		for(Integer a : l4){
			System.out.print(a+ ", ");
		}

	}
*/
}