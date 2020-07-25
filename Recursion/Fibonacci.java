import java.util.Arrays;
public class Fibonacci {
	/** This program is to get the nth Fibonacci number recursively
	and to print out the sequence up to nth Fibonacci number iteratively. */

	/** Using recursion, we get the nth Fibonacci number. */
	public static int getFib(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		return getFib(n-1) + getFib(n-2);
	}

	/** Print out the sequence up to nth Fibonacci number. */
	public static void printFib(int n) {
		int[] sequence = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			sequence[i] = getFib(i);
		}
		System.out.println(Arrays.toString(sequence));
	}

	public static void main(String[] args) {
		printFib(10);
	}
}