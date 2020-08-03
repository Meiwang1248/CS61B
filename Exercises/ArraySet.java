import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/** We build our own Array-based set, ArraySet.
 * Firstly, build a constructor and three methods: contains(), add(), and size();
 * Secondly, Let ArraySet implement Iterable and has an Iterator, ArraySetIterator.
 * Hence, we are able to loop through every element in ArraySet.
 * Thirdly, we build a toString method.
 * Lastly, we build a equals() method. */


public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    /** Adds an item to the ArraySet.
     * Exceptions
     * When we add null to our ArraySet, the program will crash since we are calling null.equals(x)
     * and will throw a NullPointerException.
     * However, we could manually throw an exception IllegalArgumentException by updating the add
     * method.*/
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("You cannot add null value to the ArraySet.");
        }
        if (this.contains(item)) {
            return;
        }
        //Invariants-- the position of our to-be-added item is size
        items[size] = item;
        size += 1;

    }

    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T toReturn = items[wizPos];
            wizPos += 1;
            return toReturn;
        }
    }

    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        ArraySet<T> udda = (ArraySet<T>) other;
        if (size != udda.size()) {
            return false;
        }
        for (T item : udda) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /** Using the built-in Class in Java, we can use nice looking iteration to
         * print out the set.*/
        Set<String> s = new HashSet<String>();
        s.add("Haley");
        s.add("Hayden");
        s.add("I love you guys");
        for (String i : s) {
            System.out.println(i);
        }
        /** Using the built-in Class in Java, we can use print out the set directly. */
        System.out.println(s);

        //However, we will need to have ArraySet implement Interface Iterable to loop
        /** To perform the loop, ArraySet needs to implement Iterable, therefore, it needs
         * an iterator() method. An Iterator method should have next() and hasNext() methods,
         * Therefore, we build a class ArraySetIterator that implements Iterator and have
         * those two methods. */
        ArraySet<Integer> aset = new ArraySet<>();
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset.add(1);
        aset.add(2);
        aset.add(3);
        aset2.add(1);
        aset2.add(2);
        aset2.add(3);
        for (int i : aset) {
            System.out.println(i);
        }
        System.out.println(aset);
        System.out.println(aset.toString());

        System.out.println(aset == aset2);
        System.out.println(aset.equals(aset2));


    }

}
