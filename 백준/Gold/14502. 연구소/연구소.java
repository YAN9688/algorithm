import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int n, m, max;
	static int[][] map;
	static List<int[]> virus;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		virus = new ArrayList<>();
		max = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		select(0, new int[3][2]);
		System.out.println(max);
	}

	static void select(int num, int[][] pos) {
		if (num == 3) {
			int[][] tmp_map = new int[n][m];
			for (int i = 0; i < n; i++) {
				tmp_map[i] = Arrays.copyOf(map[i], m);
			}
			for (int i = 0; i < 3; i++) {
				tmp_map[pos[i][0]][pos[i][1]] = 1;
			}
			check(tmp_map);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					continue;
				map[i][j] = 1;
				pos[num][0] = i;
				pos[num][1] = j;
				select(num + 1, pos);
				map[i][j] = 0;
			}
		}
	}

	static void check(int[][] tmp_map) {
		Queue<int[]> q = new LinkedList<>();
		for (int[] rc : virus) {
			q.add(rc);
		}
		while (!q.isEmpty()) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (tmp_map[nr][nc] != 0)
					continue;
				tmp_map[nr][nc] = 2;
				q.add(new int[] { nr, nc });
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp_map[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(cnt, max);
	}
}
