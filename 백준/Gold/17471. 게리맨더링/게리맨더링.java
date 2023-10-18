import java.io.*;
import java.util.*;

public class Main {
	static boolean[] sel, visited;
	static int mini;
	static int[] score;
	static ArrayList<ArrayList<Integer>> list;
	static int sum;
	static int N;
	static List<Integer> G1, G2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		score = new int[N];
		sum = 0;
		mini = Integer.MAX_VALUE;
		sel = new boolean[N];
		G1 = new ArrayList<>();
		G2 = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			int tmp = Integer.parseInt(st.nextToken());
			score[i] = tmp;
			sum += tmp;
		}
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int i = 0; i < len; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				list.get(j).add(tmp - 1);
			}
		}
		// ~입력 받기
		// 1부터 시작함으로써 중복제거
		powerset(1);
		if (mini == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(mini);

	}

	static void powerset(int idx) {
		if (idx == N) {
			visited = new boolean[N];
			G1.clear();
			G2.clear();
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					G2.add(i);
				} else
					G1.add(i);
			}
			// 0번은 무조건 false이므로 한쪽그룹만 확인
			if (G2.size() == 0)
				return;
			check(G1);
			check(G2);
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					flag = false;
					return;
				}
				if (sel[i])
					tmp += score[i];
			}
			if (flag) {
				mini = Math.min(mini, Math.abs(sum - 2 * tmp));
			}
			return;

		}
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}

	static void check(List<Integer> G) {
		Queue<Integer> q = new LinkedList<>();
		int start = G.get(0);
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int j = q.poll();
			int size = list.get(j).size();
			for (int i = 0; i < size; i++) {
				int next = list.get(j).get(i);
				if (!visited[next] && G.contains(next)) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
