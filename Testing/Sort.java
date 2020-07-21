import java.util.Arrays;

public class Sort {

    /** Sort Strings destructively. */
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sort String starting at starting index. */
    public static void sort(String[] x, int indexStart) {
        if (indexStart == x.length - 1) {
            return;
        }
        int smallestIndex = findSmallest(x, indexStart);
        swap(x, indexStart, smallestIndex);
        sort(x, (indexStart + 1));

    }

    /** Returns the index of the smallest time, starting at start. */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            if ((x[i].compareTo(x[smallestIndex]) < 0)) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /** Swaps the smallest value to the beginning of the desired array. */
    public static void swap(String[] x, int index1, int index2) {
        String temp = x[index1];
        x[index1] = x[index2];
        x[index2] = temp;
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"i", "have", "an", "egg"};
        Sort.sort(s1);
        System.out.println(Arrays.toString(s1));

        String[] s2 = new String[]{"can", "eat", "potatoes", "you"};
        Sort.sort(s2);
        System.out.println(Arrays.toString(s2));

    }
}