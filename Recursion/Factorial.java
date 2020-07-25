public class Factorial {
	public static int factRecursive(int n) {
		if (n == 0) {
			return 1;
		}
		return n*factRecursive(n-1);

	}

	public static void main(String[] args) {
		System.out.println(factRecursive(5));
	}
}