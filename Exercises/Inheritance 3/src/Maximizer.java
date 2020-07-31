import java.util.Collection;
import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].compareTo(items[maxDex]) > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog[] dogs = {d1, d2, d3};
        Dog maxDog = (Dog) max(dogs);
        //Dog maxDog = Collection.max(dogs);
        maxDog.bark();

        /** getNameComparator() returns an object in the NameComparator Class, which
         * implements Comparator<T>, therefore object nc is not only an object in
         * the NameComparator Class, but also an object under Comparator<Dog>. */
        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1,d2) > 0) { //if d1 comes after d2 alphabetically
            d1.bark();
        } else {
            d2.bark();
        }

    }
}
