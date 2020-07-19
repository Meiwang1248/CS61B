public class LinkedListDeque<T> {

    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        private TNode(TNode front, T stuff, TNode back) {
            prev = front;
            item = stuff;
            next = back;
        }
    }

    // variables of LinkedListDeque
    private TNode sentinal;
    private int size;

    //constructor
    public LinkedListDeque() {
        sentinal = new TNode(null, null, null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        size = 0;
    }

    //Copy a LinkedListDeque Constructor
    public LinkedListDeque(LinkedListDeque other) {
        sentinal = new TNode (null, null, null);
        sentinal.prev = sentinal;
        sentinal.next = sentinal;
        size = 0;
        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }

    }

    //add first method
    public void addFirst(T item) {
        sentinal.next = new TNode(sentinal, item, sentinal.next);
        sentinal.next.next.prev = sentinal.next;
        size += 1;
    }

    //add last method
    public void addLast(T item) {
        sentinal.prev = new TNode(sentinal.prev, item, sentinal);
        sentinal.prev.prev.next = sentinal.prev;
        size += 1;
    }

    //remove first if exists
    public void removeFirst() {
        //these two lines of codes work when there is only one null sentinal Tnode
        sentinal.next.next.prev = sentinal;
        sentinal.next = sentinal.next.next;
        if (size != 0) {
            size -= 1;
        }
    }

    public void removeLast() {
        //orders matter
        sentinal.prev.prev.next = sentinal;
        sentinal.prev = sentinal.prev.prev;

        if (size != 0) {
            size -= 1;
        }
    }
    //get() using iteration
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        TNode toGet = sentinal.next;
            for (int i = 0; i < index; i++) {
                toGet = toGet.next;
            }
            return toGet.item;
    }


    //get() using recursion
    private T getRecursive(int index, TNode curr) {

        if (index == 0) {
            return curr.item;
        } else {
            //get() means take out the drawer: go to next, then take out the drawer.
            return getRecursive(index - 1, curr.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinal.next);
    }


    public int size() {

        int size = this.size;
        return size;
    }

    public void printDeque() {
        //loop every Tnode
        TNode toPrint = sentinal.next;
        for (int i = 0; i < size; i++) {
            System.out.print(toPrint.item + " ");
            toPrint = toPrint.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<String> ph = new LinkedListDeque<String>();
        ph.addFirst("I");
        System.out.println(ph.get(0));
        System.out.println(ph.size);
        ph.addLast("love");
        ph.addLast("you");
        ph.printDeque();
        System.out.println(ph.size());
        ph.removeLast();
        ph.addLast("U too");
        ph.printDeque();

    }
}