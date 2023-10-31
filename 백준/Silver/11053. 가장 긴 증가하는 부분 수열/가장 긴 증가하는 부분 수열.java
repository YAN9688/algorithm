import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] dp, arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}