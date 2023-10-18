import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N]; // 선행 노드 갯수
			int[] time = new int[N]; // 걸리는 시간
			int[] dp = new int[N];
			ArrayList<LinkedList<Integer>> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				list.add(new LinkedList<>());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a - 1).add(b - 1);
				arr[b - 1]++;
			}

			int target = Integer.parseInt(br.readLine()) - 1;

			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					q.add(i);
					dp[i] = time[i];
				}
			}

			while (!q.isEmpty()) {
				if (arr[target] == 0)
					break;
				int start = q.poll();
				for (int i = 0; i < list.get(start).size(); i++) {
					int next = list.get(start).get(i);
					dp[next] = Math.max(dp[next], dp[start] + time[next]);
					if (--arr[next] == 0) {
						q.add(next);
					}
				}
			}
			sb.append(dp[target]).append("\n");
		}

		System.out.print(sb.toString());
	}
}
