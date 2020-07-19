/** Array based list.
 *  @author Mei Wang
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/
public class AList<Item> {
	private Item[] items;
	private int size;

	/** Create an empty list. */
	public AList() {
		/* usually items = new int[100]; but this undeclared type */
		items = (Item[]) new Object[100];
		size = 0;
	}


	public void addLast(Item x) {
		if (size == items.length) {
			resize(size + 1);
		}
		items[size] = x;
		size += 1;
	}
	/* Given an index, get the item in the array */
	public Item get(int index) {
		return items[index]; 
	}

	public Item getLast() {
		return items[size - 1];
	}

	public Item removeLast() {
		Item toDelete = getLast();
		items[size - 1] = null;
		size -= 1;
		return toDelete;
	}
	/* This method return the size of the AList */
	public int size() {
		return size;
	}

	public void resize(int capacity) {
		Item[] newArray = (Item[]) new Object[capacity];
		System.arraycopy(this, 0, newArray, 0, size);
		this.items = newArray;
		/** original line but it's wrong because the size won't change after
		 copying :size = size + (capacity - size); */
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(items[i] + " ");
		}
	}
	public static void main(String[] args) {
		AList<Integer> a1 = new AList<Integer>();
		a1.addLast(1);
		a1.addLast(2);
		a1.addLast(3);
		for (int i = 4; i < 101; i++) {
			a1.addLast(i);
		}
		System.out.println(a1.size);
		a1.print();
	}
}