import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int answer = 0;
			int[][] graph = new int[N][N];
			for (int i = 0; i < M; i++) {
				graph[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
			}
			for (int i = 0; i < N; i++) {
				List<Integer> list = new ArrayList<>();
				for (int j = i + 1; j < N; j++) {
					if (graph[i][j] == 1)
						list.add(j);
				}
				int l = list.size();
				if (l >= 2) {
					for (int p1 = 0; p1 < l - 1; p1++) {
						for (int p2 = p1 + 1; p2 < l; p2++) {
							if (graph[list.get(p1)][list.get(p2)] == 1)
								answer++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}