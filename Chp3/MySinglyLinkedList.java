//program: 单链表
import java.util.*;

public class MySinglyLinkedList<Anytype> implements Iterable<Anytype>{
	private class Node<Anytype>{
		public Anytype data;
		public Node next;

		public Node(Anytype x, Node ne){
			data=x;
			next=ne;
		}
	}

	private Node<Anytype> head;
	private int theSize();

	public MySinglyLinkedList(){
		head = new Node(null, null);
		theSize=0;
	}
	
	public int size(){
		return theSize;
	}

	public void add(Anytype x){
		add(size(),x);
	}

	public void add(int idx,Anytype x){
		addAfter(getNode(idx-1) , x);
	}

	public void addAfter(Node<Anytype> nd, Anytype x){
		Node<Anytype> new_nd = new Node<Anytype>(x, nd.next);
		nd.next=new_nd; 
	}

	private Node<Anytype> getNode(int idx){
		if (idx<0 && idx>=size) {
			throw new IndexOutOfBoundsException();
		}
		Node<Anytype> nd=head;
		for(int i=0;i<=idx;i++){
			nd=nd.next;
		}
		return nd;
	}

	public Anytype get(int idx){
		return getNode(idx).data;
	}

	public Iterator<Anytype> iterator(){
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<Anytype>{
		private Node<Anytype> current = head;
		private Node<Anytype> pre = null;
		private okToRemove = false;
		public boolean hasNext(){
			return current.next!=null;
		}

		public Anytype next(){
			if (!hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			Anytype val = current.data;
			pre = current;
			current=current.next;
			return val;
		}

		public void remove(){
			if(!pre){
				throw new IllegalStateException();
			}
			MySinglyLinkedList.this.remove(pre);
			pre=null;
		}
	}

}