public class Staircase {
	/** This program is to calculate the number of ways to climb n stairs
	if each progress can only be either one or two steps. */
		public static int countWays(int n) {
			//base case
			if(n == 0 || n == 1) {
				return 1;
			}
			//case 1: if we climb 1 step at the beginning, there are (n-1) stairs to climb. 
			//case 2: if we clime 2 steps at the beginning, there are (n-2) stairs to climb.
			return countWays(n - 1) + countWays(n - 2);
		}

		public static void main(String[] args) {
			System.out.println(countWays(10));
		}


}