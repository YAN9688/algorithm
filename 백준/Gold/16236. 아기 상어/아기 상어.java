import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int r0 = 0;
		int c0 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if (tmp == 9) {
					r0 = i;
					c0 = j;
					map[i][j] = 0;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		q.add(new int[] { r0, c0 });
		int size = 2; // 상어 사이즈
		int size_tmp = 0; // 해당 사이즈에서 먹은 갯수
		int sum = 0; // 누적 시간
		while (!q.isEmpty()) { // 시작
			boolean[][] visited = new boolean[n][n];
			visited[r0][c0] = true;
			int time = 0;
			if (size_tmp == size) {
				size++;
				size_tmp = 0;
			}
			while (!q.isEmpty()) { // 먹을 곳 찾기
				time++;
				int qsize = q.size(); // time 단위로 끊기
				for (int i = 0; i < qsize; i++) {
					int[] pos = q.poll();
					int r = pos[0];
					int c = pos[1];
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < 0 || nc < 0 || nr >= n || nc >= n)
							continue;
						if (visited[nr][nc] || map[nr][nc] > size)
							continue;
						if (map[nr][nc] != 0 && map[nr][nc] < size) {
							list.add(new int[] { nr, nc });
						} else {
							q.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
				}
				if (list.size() > 0) {// 먹기
					list.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
					int[] first = list.get(0);
					r0 = first[0];
					c0 = first[1];
					map[r0][c0] = 0;
					q.clear();
					q.add(new int[] { r0, c0 });
					sum += time;
					size_tmp++;
					list.clear();
					break;
				}
			}
			// 먹고 새로 시작
		}
		System.out.println(sum);
	}
}
