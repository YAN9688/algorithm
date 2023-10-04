import java.util.*;

public class Solution {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tp = sc.nextInt();
					map[i][j] = tp;
					if (tp == 1)
						visited[i][j] = true;
				}
			}
			int sr0 = sc.nextInt();
			int sc0 = sc.nextInt();
			int fr = sc.nextInt();
			int fc = sc.nextInt();
			Queue<Integer[]> q = new LinkedList<>();
			q.add(new Integer[] { sr0, sc0 });
			int time = 0;
			int answer = -1;
			ol: while (!q.isEmpty()) {
				time++;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Integer[] point = q.poll();
					int r = point[0];
					int c = point[1];
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
							if (map[nr][nc] == 2 && time % 3 != 0) {
								q.add(new Integer[] { r, c });
							} else {
								if (nr == fr && nc == fc) {
									answer = time;
									break ol;
								}
								q.add(new Integer[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
