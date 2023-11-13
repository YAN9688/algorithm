import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][3];
		int[][] dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k)
						continue;
					dp[i][j] = Math.min(dp[i - 1][k] + map[i][j], dp[i][j]);
				}
			}
		}
		System.out.println(Arrays.stream(dp[n - 1]).min().getAsInt());
	}
}
