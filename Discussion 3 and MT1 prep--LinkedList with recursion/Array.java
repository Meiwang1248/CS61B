import java.util.Arrays;

public class Array {
    /** Consider a method that inserts an int item into an int[] arr at the given position.
    The method should return the resulting array. For example, if x = [5, 9, 14, 15],
    item = 6, and position = 2, then the method should return [5, 9, 6, 14, 15].
    If position is past the end of the array, insert item at the end of the array. */

    public static int[] insert(int[] oldArray, int x, int position) {
        int[] newArray = new int[oldArray.length + 1];
        System.arraycopy(oldArray,0, newArray,0, position);
        newArray[position] = x;
        System.arraycopy(oldArray,position, newArray, position +1, newArray.length - position -1);
        return newArray;
    }

    /** Reverse an array destructively, no keyword new used. */
    public static int[] reverse(int[] arr) {
        if (arr.length % 2 == 1) {
            for (int i = 0; i < (arr.length - 1) / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        } else {
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        }
    }

    /** This method is to replaces the
     number at index i with arr[i] copies of itself. For example, replicate([3, 2,
     1]) would return [3, 3, 3, 2, 2, 1]. For this question assume that all elements
     of the array are positive. */
    public static int[] replicate(int[] arr) {
        int[] newArray = new int[sum(arr)];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0 ; j < arr[i]; j++) {
                int start = sumTo(arr, i);
                newArray[j + start] = arr[i];
            }
        }
        return newArray;



    }

    /** This is a helper method for replicate(). It sums the values in an array. */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /** This is a helper method for replicate(). It sumes the
     * values up to nth index. */
    public static int sumTo(int[] arr, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public static void main(String[] agrs) {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(insert(numbers,100, 3)));
        int[] num = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println(Arrays.toString(insert(num,100, 8)));
        System.out.println(Arrays.toString(reverse(numbers)));
        System.out.println(Arrays.toString(reverse(num)));
        System.out.println(Arrays.toString(replicate(numbers)));
        System.out.println(replicate(num).length);


    }
}
