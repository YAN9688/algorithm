import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dp[1][1] = map[0][0];
		for (int i = 2; i <= n; i++) {
			dp[i][1] = dp[i - 1][1] + map[i - 1][0];
			dp[1][i] = dp[1][i - 1] + map[0][i - 1];
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = -dp[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] + map[i - 1][j - 1];
			}
		}
//		System.out.println("\n");
//		for (int[] a : dp) {
//			System.out.println(Arrays.toString(a));
//		}
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < m; tc++) {
			int s_r = sc.nextInt();
			int s_c = sc.nextInt();
			int e_r = sc.nextInt();
			int e_c = sc.nextInt();
			sb.append(dp[e_r][e_c] + dp[s_r - 1][s_c - 1] - dp[e_r][s_c - 1] - dp[s_r - 1][e_c]).append("\n");
		}
		System.out.println(sb.toString());

	}
}
