import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb;
	static boolean[] sel;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		sel = new boolean[n];
		comb(0, new int[m]);

		System.out.println(sb.toString());
	}

	static void comb(int len, int[] ord) {
		if (len == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[ord[i]] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (sel[i])
				continue;
			sel[i] = true;
			ord[len] = i;
			comb(len + 1, ord);
			sel[i] = false;
		}
	}
}