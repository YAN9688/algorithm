class Solution {
	static boolean[] visited;
	static int answer;
	static int n;
    static int[] nums;
	public int solution(int[] numbers, int target) {
		answer = 0;
		n = numbers.length;
		visited = new boolean[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum+ numbers[i];
		}
        nums = numbers;
		int diff = sum - target;
		sel(0, diff);
		return answer;
	}
	static void sel(int idx,int diff) {
		if (diff < 0)
			return;
		else if (diff == 0) {
			answer++;
			return;
		}
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel( i , diff - (nums[i] * 2));
				visited[i] = false;
			}
		}
	}
}