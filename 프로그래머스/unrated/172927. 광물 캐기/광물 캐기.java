import java.util.*;

class Solution {
	static int tired;
	static int[][] board = { { 1, 1, 1 }
                            ,{ 5, 1, 1 }
                            ,{ 25, 5, 1 } };
	static Map<String, Integer> map = new HashMap<>();
	static int[] order;

	public int solution(int[] picks, String[] minerals) {
		map.put("diamond", 0);
		map.put("iron", 1);
		map.put("stone", 2);
		order = new int[Arrays.stream(picks).sum()];
		Arrays.fill(order, -1);
		tired = Integer.MAX_VALUE;
		dfs(0, order, picks, minerals);
		return tired;
	}

	static void dfs(int len, int[] order, int[] picks, String[] minerals) {
		if (len == order.length || len == (int) (minerals.length / 5) + 0.8) {
			int temp_score = 0;
			int minerals_index = 0;
			int order_index = 0;
			ol: while (order_index < order.length) {
				for (int i = 0; i < 5; i++) {
					if (minerals_index == minerals.length)
						break ol;
					temp_score += board[order[order_index]][map.get(minerals[minerals_index++])];
				}
				order_index++;
			}
			tired = Math.min(temp_score, tired);
			return;
		}
		for (int i = 0; i < picks.length; i++) {
			if (picks[i] != 0) {
				picks[i]--;
				order[len] = i;
				dfs(len + 1, order, picks, minerals);
				picks[i]++;
				order[len] = -1;
			}
		}
	}
}