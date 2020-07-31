import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }



    @Override
    public int compareTo(Dog uddadog) {
        return this.size - uddadog.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    /** This method is to create an object in the NameComparator Class. */
    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
