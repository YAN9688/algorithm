class Solution {
	static boolean[] visited;
	static int answer;
	static int n;

	public int solution(int[] numbers, int target) {
		answer = 0;
		n = numbers.length;
		visited = new boolean[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + numbers[i];
		}
		int diff = sum - target;
		sel(numbers, 0, diff);
		return answer;
	}

	static void sel(int[] numbers, int idx, int diff) {
		if (diff < 0)
			return;
		else if (diff == 0) {
			answer++;
			return;
		}
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel(numbers, i + 1, diff - (numbers[i] * 2));
				visited[i] = false;
			}
		}
	}
}