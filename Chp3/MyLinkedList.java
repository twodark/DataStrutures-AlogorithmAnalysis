//author: uygnin
//Data Struture: ArrayList

import java.util.*;

public class MyLinkedList<Anytype> implements Iterable<Anytype>{
	//test
	public static void main(String[] args){
		MyLinkedList<Integer> lst = new MyLinkedList<Integer>();
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

	public LinkNode<Anytype> header;
	public LinkNode<Anytype> tail;
	int theSize;

	public MyLinkedList(){
		clear();
	}

	public void clear(){
		header=new LinkNode<Anytype>(null,null,null);
		tail=new LinkNode<Anytype>(null,header,null);
		header.nextNode=tail;
		theSize=0;
	}

	public int size(){
		return theSize;
	}

	public boolean isEmpty(){
		return theSize==0;
	}

	public Anytype get(int idx){
		return getNode(idx).data;
	}

	public boolean contains(Anytype val){
		Iterator<Anytype> itr = iterator();
		while(itr.hasNext()){
			Anytype test_val = itr.next();
			if(test_val == val){
				return true;
			}
		}
		return false;
	}

	private LinkNode<Anytype> getNode(int idx){
		if(idx<0 || idx>theSize){
			throw new IndexOutOfBoundsException();
		}
		LinkNode<Anytype> p;
		if(idx<size()/2){
			p = header.nextNode;
			for(int i=0;i<idx;i++){
				p=p.nextNode;
			}
		}else{
			p = tail;
			for(int i=theSize; i>idx; i--){
				p=p.prevNode;
			}
		}
		return p;
	}

	public Anytype set(int idx, Anytype new_val){
		LinkNode<Anytype> p = getNode(idx);
		Anytype old_val = p.data;
		p.data=new_val;
		return old_val;
	}

	public void add(Anytype v){
		add(size(),v);
	}

	public void add(int idx, Anytype val){
		addBefore(getNode(idx),val);
	}

	private void addBefore(LinkNode<Anytype> node, Anytype x ){
		LinkNode<Anytype> new_node = new LinkNode<Anytype>(x, node.prevNode, node);
		node.prevNode.nextNode=new_node;
		node.prevNode=new_node;
		theSize++;
	}

	public Anytype remove(int idx){
		return remove(getNode(idx));
	}

	private Anytype remove(LinkNode<Anytype> node){
		node.prevNode.nextNode=node.nextNode;
		node.nextNode.prevNode=node.prevNode;
		theSize--;
		return node.data;
	}

	public void removeAll(Iterable<? extends Anytype> new_items_itr){
		Iterator<? extends Anytype> new_items = new_items_itr.iterator();
		while(new_items.hasNext()){
			Anytype val_to_del=new_items.next();
			Iterator itr = iterator();
			while(itr.hasNext()){
				if(itr.next().equals(val_to_del)){
					itr.remove();
				}
			}
		}
	}

	public Iterator<Anytype> iterator(){
		return new LinkNodeIterator();
	}

	private class LinkNodeIterator implements Iterator<Anytype>{
		
		private LinkNode<Anytype> current=header.nextNode;
		private boolean okToRemove=false;
		
		public boolean hasNext(){
			return current!=tail;
		}

		public Anytype next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Anytype val = current.data;
			current=current.nextNode;
			okToRemove=true;
			return val;
		}

		public void remove(){
			if(!okToRemove){
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prevNode);
			okToRemove=false;
		}
	}

	private class LinkNode<Anytype>{
		public Anytype data;
		public LinkNode<Anytype> prevNode;
		public LinkNode<Anytype> nextNode;

		public LinkNode(Anytype ele, LinkNode<Anytype> pre, LinkNode<Anytype> next){
			data=ele;
			prevNode=pre;
			nextNode=next;
		}
	}
}