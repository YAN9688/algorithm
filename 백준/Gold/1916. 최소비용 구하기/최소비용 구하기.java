import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<int[]>[] node = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			node[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			node[a].add(new int[] { b, c });
		}
		int[] toCost = new int[n + 1];
		Arrays.fill(toCost, Integer.MAX_VALUE);
		int start = sc.nextInt();
		int end = sc.nextInt();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 });
		toCost[start] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int from = tmp[0];
			int sum = tmp[1];
			if (sum > toCost[from])
				continue;
			for (int i = 0; i < node[from].size(); i++) {
				int to = node[from].get(i)[0];
				int sumover = sum + node[from].get(i)[1];
				if (toCost[to] > sumover) {
					toCost[to] = sumover;
					q.add(new int[] { to, sumover });
				}
			}
		}
		System.out.println(toCost[end]);
	}
}
