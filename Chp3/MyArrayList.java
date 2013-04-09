//author: uygnin
//Data Struture: ArrayList

import java.util.*;

public class MyArrayList<Anytype> implements Iterable<Anytype>{
	
	private Anytype[] items;
	private int theSize;
	private final int DEFAULT_SIZE=10;

	public void clear(){
		theSize=0;
		ensureCapaciy(DEFAULT_SIZE);
	}

	public MyArrayList(){
		clear();
	}

	private void ensureCapaciy(int newCap){
		if(newCap<size()){
			return;
		}
		Anytype[] new_items = (Anytype[])new Object[newCap];
		for (int i=0 ; i<size(); i++) {
			new_items[i]=items[i];
		}
		items = new_items;
	}

	public int size(){
		return theSize;
	}

	public boolean isEmpty(){
		return theSize==0;
	}

	public void add(Anytype v){
		add(size(),v);
	}

	public void trimToSize(){
		ensureCapaciy(size());
	}

	public void add(int idx, Anytype v){
		if(items.length==size()){
			ensureCapaciy(2*size()+1);
		}

		for(int i=size()-1; i>=idx;i--){
			items[i+1]=items[i];
		}
		items[idx]=v;
		theSize++;
	}

	public void addAll(Iterable<? extends Anytype> new_items){
		Iterator<? extends Anytype> new_itr = new_items.iterator();
		while(new_itr.hasNext()){
			add(new_itr.next());
		}	
	}

	public Anytype get(int idx){
		if(idx<0 || idx >size()-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		return items[idx];
	}

	public Anytype set(int idx, Anytype v){
		if(idx<0 || idx >size()-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		Anytype old_val=items[idx];
		items[idx]=v;
		return old_val;
	}

	public Anytype remove(int idx){
		Anytype tmp = get(idx);
		for(int i=idx; i<size()-1; i++){
			items[i]=items[i+1];
		}
		theSize--;
		return tmp;
	}


	public Iterator<Anytype> iterator(){
		return new MyArrayIterator();
	}

	private class MyArrayIterator implements Iterator<Anytype>{
		
		private int count=0;

		public boolean hasNext(){
			return count<size();
		}

		public Anytype next(){
			if(!hasNext()){
				throw new ArrayIndexOutOfBoundsException();
			}
			return items[count++];
		}

		public void remove(){
			MyArrayList.this.remove(--count);
		}
	}
	
	//test
	public static void main(String[] args){
		MyArrayList<Integer> lst = new MyArrayList<Integer>();
		for(int i=0; i<15;i++){
			lst.add(i);
		}

		for(Integer a : lst){
			System.out.print(a+", ");
		}

		System.out.println();

		for (int j=0; j<8;j++ ) {
			lst.remove(0);
		}
		
		for(Integer a : lst){
			System.out.print(a+ ", ");
		}

		Iterator<Integer> itr = lst.iterator();
		while (itr.hasNext()) {
			Integer i = itr.next();
			System.out.println("deleting "+i);
			itr.remove();
		}
		
		for(Integer a : lst){
			System.out.print(a+ ", ");
		}
		System.out.println("isEmpty ?: " + lst.isEmpty());
	}

}