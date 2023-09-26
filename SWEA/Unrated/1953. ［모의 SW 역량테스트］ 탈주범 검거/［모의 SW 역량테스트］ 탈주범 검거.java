import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder result = new StringBuilder();
		for (int t_c = 1; t_c <= T; t_c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, -1, 0, 1 };
			boolean[][] visit = new boolean[N][M];
			boolean[][] tf = { { false, false, false, false }, { true, true, true, true }, { true, false, true, false },
					{ false, true, false, true }, { true, false, false, true }, { false, false, true, true },
					{ false, true, true, false }, { true, true, false, false } };
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Integer[]> q = new LinkedList<>();
			q.add(new Integer[] { R, C });
			int answer = 1;
			while (!q.isEmpty()) {
				if (--L == 0)
					break;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Integer[] rc = q.poll();
					int tr = rc[0];
					int tc = rc[1];
					visit[tr][tc] = true;
					for (int d = 0; d < 4; d++) {
						int nr = tr + dr[d];
						int nc = tc + dc[d];
						if (0 > nr || nr >= N || 0 > nc || nc >= M || visit[nr][nc])
							continue;
						else if (tf[map[tr][tc]][d] && tf[map[nr][nc]][(d + 2) % 4]) {
							q.add(new Integer[] { nr, nc });
							visit[nr][nc] = true;
							answer++;
						}
					}
				}
			}
			result.append("#").append(t_c).append(" ").append(answer).append("\n");
		}
		System.out.print(result.toString());
	}
}