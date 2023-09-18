import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			int answer = 0;
			int[][] graph = new int[N][N];

			for (int i = 0; i < M; i++) {
				String[] edgeData = br.readLine().split(" ");
				graph[Integer.parseInt(edgeData[0]) - 1][Integer.parseInt(edgeData[1]) - 1] = 1;
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
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
}
