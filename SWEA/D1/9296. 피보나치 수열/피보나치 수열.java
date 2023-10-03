
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int[] memo;
	static int fibo(int n) {
		if (memo[n] == -1) {
			memo[n] = fibo(n - 1) + fibo(n - 2);
		}
		return memo[n];
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 5;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			memo = new int[N + 1];
			Arrays.fill(memo, -1);
			memo[0] = 0;
			memo[1] = 1;
			System.out.println(fibo(N));
		}
	}
}