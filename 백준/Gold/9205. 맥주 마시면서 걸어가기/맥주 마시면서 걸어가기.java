import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[] sel;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			flag = false;
			sel = new boolean[n + 1];
			map = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			per(0);
			sb.append(flag ? "happy" : "sad").append("\n");
		}
		System.out.println(sb.toString());
	}

	static void per(int before) {
		if (flag)
			return;
		
		if (Math.abs(map[before][0] - map[n + 1][0]) + Math.abs(map[before][1] - map[n + 1][1]) <= 1000) {
			flag = true;
			return;
		}
		for (int next = 1; next <= n; next++) {
			if (!sel[next]
					&& Math.abs(map[before][0] - map[next][0]) + Math.abs(map[before][1] - map[next][1]) <= 1000) {
				sel[next] = true;
				per(next);
			}
		}
	}
}