import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		int n = scoville.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(scoville[i]);
		}
		if (pq.peek() == 0) {

			return -1;
		}
		while (true) {
			int a = pq.poll();
			if (a >= K) {
				break;
			}
			if (pq.isEmpty()) {
				answer = -1;
				break;
			}
			int b = pq.poll();
			pq.add(a + 2 * b);
			answer++;
		}
		return answer;
	}
}