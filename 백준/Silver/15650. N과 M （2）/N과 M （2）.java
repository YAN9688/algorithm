import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sb = new StringBuilder();
		comb(0, 0, new StringBuilder());
		sel = new boolean[n + 1];
		System.out.println(sb.toString());
	}

	static void comb(int len, int idx, StringBuilder tmp) {
		if (len == m) {
			sb.append(tmp + "\n");
			return;
		}

		for (int i = idx + 1; i <= n; i++) {
			comb(len + 1, i, tmp.append(i + " "));
			tmp.delete(tmp.length() - 2, tmp.length());
		}
	}
}