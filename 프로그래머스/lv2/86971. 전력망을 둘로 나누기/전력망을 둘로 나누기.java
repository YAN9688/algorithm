import java.util.*;

class Solution {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int len;

	public int solution(int n, int[][] wires) {
		int mini = n;
		list = new ArrayList<>();
		for (int j = 0; j < n - 1; j++) {
			list.clear();
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 0; i < n - 1; i++) {
				if (j == i)
					continue;
				list.get(wires[i][0] - 1).add(wires[i][1] - 1);
				list.get(wires[i][1] - 1).add(wires[i][0] - 1);
			}
			len = 0;
			visited = new boolean[n];
			dfs(0);
			int diff = Math.abs(len - (n - 2 - len));
			mini=Math.min(diff,mini);
		}
		return mini;
	}

	static void dfs(int node) {
		visited[node] = true;
		for (int neighbor : list.get(node)) {
			if (!visited[neighbor]) {
				len++;
				dfs(neighbor);
			}
		}
	}
}