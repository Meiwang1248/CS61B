/**
 * ArrayDeque
 * implemented in circular way
 * @author Mei
 */


public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /** Create an empty ArrayDeque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /** Create a deep copy of an ArrayDeque. */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        nextFirst = other.nextFirst;
        nextLast = plusOne(other.nextFirst); //set the start point
        size = 0;
        //As arraycopy can't work with circular array
        int oldIndex = nextLast;
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.items[oldIndex]);
            oldIndex = plusOne(oldIndex);
        }

    }

    /** For nextFirst and nextLast to plus one circularly. */
    public int plusOne(int index) {
        /** remainder % */
        return (index + 1) % items.length;
    }

    /** For nextFirst and nextLast to plus one circularly. */
    public int minusOne(int index) {
        /** +items.length in order to make sure (index + 1 + items. length)
         * is positive, because we do not want a negative remainder, which will
         * becomes our index. */
        return (index - 1 + items.length) % items.length;

    }

    /** Check if the Deque is full. */
    public boolean isFull() {
        return size == items.length;
    }

    /** Check if the Deque is sparsed. */
    public boolean isSparse() {
        return (items.length >= 16) && (size < (0.25 * items.length));
    }

    /** Resize the array to a given capacity. */
    public void resize(int capacity) {
        /**  My original code. It doesn't work because arraycopy does not expect
         * your array to be circular.
         * Item[] a = (Item[]) new Object[capacity];
         *     int start = plusOne(nextFirst);
         *     System.arraycopy(items, start, a, 0, size);
         *     items = a; */
        T[] a = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            a[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = a;
        nextFirst = capacity - 1; //as the new deque starts from the true index 0.
        nextLast = size;

    }
    /** Increase the size of a given array. */
    public void upSize() {
        this.resize(size * 2);
    }

    /** Decrease the size of a given array. */
    public void downSize() {
        this.resize(items.length / 2);
    }

    /** As this is a circular array, get() will get your the ith item for the
     * start point of the array, not the array[0].*/
    public T get(int index) {
        /** This condition is really tricky, (index >= size) works no matter
         * where the items[] starts.
         * modified: In fact, this is not tricky as long as you see the items[]
         * as a floating array, getting index grearter or equals to size will
         * give you null value. The input index means the index of items[],
         * not the index of the exact array. */
        if (index >= size) {
            return null;
        }
        int starter = plusOne(nextFirst);
        return items[(starter + index) % items.length];
    }
    /** Add item to the beginning of the array. */
    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Add item to the end of the array. */
    public void addLast(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Remove item from the beginning. */
    public T removeFirst() {
        if (isSparse()) {
            downSize();
        }
        if (size == 0) {
            return null;
        } else {
            nextFirst = plusOne(nextFirst);
            T toRemove = items[nextFirst];
            items[nextFirst] = null;
            if (size > 0) {
                size -= 1;
            }
            return toRemove;
        }


    }

    /** Remove item from the beginning. */
    public T removeLast() {
        if (isSparse()) {
            downSize();
        }
        if (size == 0) {
            return null;
        } else {
            nextLast = minusOne(nextLast);
            T toRemove = items[nextLast];
            items[nextLast] = null;
            if (size > 0) {
                size -= 1;
            }
            return toRemove;
        }


    }

    /** Print the ArrayDeque. */
    public void printDeque() {
        int start = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[(start + i) % items.length] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<Integer>();
        for (int i = 1; i < 101; i++) {
            a1.addLast(i);
        }
        a1.printDeque();
        System.out.println();
        System.out.println(a1.size);
        for (int i = 1; i < 81; i++) {
            a1.removeFirst();
        }
        a1.printDeque();
        System.out.println();
        System.out.println(a1.size);
        for (int i = 260; i > 99; i -= 2) {
            a1.addFirst(i);
        }
        a1.printDeque();
        System.out.println();
        System.out.println(a1.size);
    }
}