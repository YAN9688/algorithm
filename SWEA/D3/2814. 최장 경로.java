import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int maxi;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			graph.clear();
			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			visited = new boolean[N];
			maxi = 1;
			for (int i = 0; i < N; i++)
				dfs(i, 1);
			System.out.println("#" + tc + " " + maxi);
		}
	}

	public static void dfs(int x, int cnt) {
		if (cnt > maxi)
			maxi = cnt;
		visited[x] = true;
		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited[y])
				dfs(y, cnt + 1);
		}
		visited[x] = false;
	}
}

/*
마지막줄 visited[x] = false; 이부분을 간과해서 디버깅에 시간이 걸렸는데
정말 중요한 요소였다. 이것에 대해서 꼭 생각해보기!

*/
