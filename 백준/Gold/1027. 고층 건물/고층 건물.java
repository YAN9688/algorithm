import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				boolean flag = true;
				for (int k = i + 1; k < j; k++) {
					if ((long) (arr[k] - arr[i]) * (j - i) >= (long) (arr[j] - arr[i]) * (k - i)) {
						flag = false;
						break;
					}
				}
				for (int k = i - 1; k > j; k--) {
					if ((long) (arr[k] - arr[i]) * (j - i) <= (long) (arr[j] - arr[i]) * (k - i)) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}
}
