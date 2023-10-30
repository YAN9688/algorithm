import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dp;
	static char[] a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.next().toCharArray();
		b = sc.next().toCharArray();
		dp = new int[a.length ][b.length];
		for (int i = 0; i < a.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(fn(a.length-1, b.length-1));
	}

	public static int fn(int r, int c) {
		if (r < 0 || c < 0) {
			return 0;
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
			
		} else if (a[r] == b[c]) {
			dp[r][c] = fn(r - 1, c - 1) + 1;
		} else {
			dp[r][c] = Math.max(fn(r - 1, c), fn(r,c-1));
		}
		return dp[r][c];
	}
}