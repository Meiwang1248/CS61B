public class SLList {
/* An SLList is a list of integers, which hides the terrible truth
   of the nakedness within. It acts like a middle-man, so that the users do not need to know the data structure of the IntList
   while users are still able to add elements and find the size of the IntList, using the methods in SLList*/
	private class IntNode{
		//This is the nested class in SLList
		public int item;
		public IntNode next;
		public IntNode(int x, IntNode L) {
			this.item = x;
			this.next = L;
		}
	}

	private IntNode sentinel;
	private int size;
	//Constructor--creating an object in SLList by defining its sentinel and size.
	public SLList (int x) {
	    sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size += 1;
	}
	//Constructor--creating an empty SLList.
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}
	//Everytime we add an IntNode object, whose item = x, at the beginning, we add it after the sentinel,
	// and link the new IntNode's next to the original second IntNode.
	public void addFirst(int x) {

		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}
	//
	public void addLast(int x) {
		IntNode p = this.sentinel;
		//Advance p to the end of the IntNode
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		//Try out a non-empty list
		SLList L = new SLList(2);
		L.addFirst(1);
		L.addLast(3);
		System.out.println(L.size());

		//Try out an empty list
		SLList L_e = new SLList();
		L_e.addLast(100);
		L_e.addFirst(99);
		L_e.addFirst(98);
		System.out.println(L_e.size());


	}

} 
