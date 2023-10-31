import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[n][n];
		dp[n - 1] = map[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++)
				dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + map[i][j];
		}
		System.out.println(dp[0][0]);
	}
}