import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		Queue<Integer[]> q = new LinkedList<>();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if (tmp == 0)
					flag = true;
				if (tmp == 1) {
					q.add(new Integer[] { i, j });
				}
			}
		}
		if (!flag) {
			System.out.println(0);
		} else {
			int day = 0;
			while (!q.isEmpty()) {
				day++;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Integer[] rc = q.poll();
					int r = rc[0];
					int c = rc[1];
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || map[nr][nc] == 1 || map[nr][nc] == -1
								|| visited[nr][nc])
							continue;
						visited[nr][nc] = true;
						map[nr][nc] = 1;
						q.add(new Integer[] { nr, nc });
					}
				}
			}
			flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						flag = false;
				}
			}
			if (!flag)
				System.out.println(-1);
			else
				System.out.println(day - 1);
		}
	}
}
