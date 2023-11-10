import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static List<int[]> home, chick;
	static int mini;
	static boolean sel[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		home = new ArrayList<>();
		chick = new ArrayList<>();
		mini = 987654321;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if (tmp == 1) {
					home.add(new int[] { i, j });
				} else if (tmp == 2) {
					chick.add(new int[] { i, j });
				}
			}
		}
		sel = new boolean[chick.size()];
		dfs(0, 0);
		System.out.println(mini);
	}

	static void dfs(int depth, int idx) {
		if (depth == m) {
			int sum = 0;
			for (int[] h : home) {
				int dist = 98754321;
				for (int i = 0; i < chick.size(); i++) {
					if (sel[i]) {
						int[] c = chick.get(i);
						dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
					}
				}
				sum += dist;
			}
			mini = Math.min(sum, mini);
			return;
		}
		if (idx == chick.size())
			return;
		sel[idx] = true;
		dfs(depth + 1, idx + 1);
		sel[idx] = false;
		dfs(depth, idx + 1);

	}
}