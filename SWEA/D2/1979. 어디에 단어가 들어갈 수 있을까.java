import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int cnt = 0;
			int[][] map = new int[N + 2][N + 2];
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			int[][] rowSum = new int[N + 2][N + 2];
			int[][] colSum = new int[N + 2][N + 2];

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					rowSum[r][c] = rowSum[r][c - 1] + map[r][c];
					colSum[r][c] = colSum[r - 1][c] + map[r][c];
				}
			}
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (map[r][c] == 1) {
						if (c + K <= N + 1 && map[r][c - 1] == 0 && map[r][c + K] == 0
								&& rowSum[r][c + K - 1] - rowSum[r][c] == K - 1) {
							cnt++;
						}
						if (r + K <= N + 1 && map[r - 1][c] == 0 && map[r + K][c] == 0
								&& colSum[r + K - 1][c] - colSum[r][c] == K - 1) {
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq

python에서는 sum(map[r][c:c+k]) 처럼 간단하게 구할 수 있는 슬라이스의 합이, 자바에서는 꽤나 복잡했다.
loop를 이용할 수 있다면 그다지 복잡한 과정이 아니겠지만, if의 조건문 안에서 이것을 구현하려고 하니, loop사용이 어려웠다.
그렇기에 1. 메서드를 따로 만드는 방법과 2. 누적합의 배열을 만드는 방법 두가지를 떠올려봤는데
두번째 방식이 조금 더 간단한 것 같아서 그렇게 구현해 보았다.
*/
