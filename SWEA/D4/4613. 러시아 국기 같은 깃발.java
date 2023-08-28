import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] map = new char[N][M];
			for (int r = 0; r < N; r++) {
				map[r] = sc.next().toCharArray();
			}
			int min = N * M;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i+1; j < N - 1; j++) {
					int cnt = 0;
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (r <= i && map[r][c] != 'W')
								cnt++;
							if (r > i && r <= j && map[r][c] != 'B')
								cnt++;
							if (r > j && map[r][c] != 'R')
								cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
			}
			System.out.println("#" + test_case + " " + min);
		}
	}
}

/*
범위설정 유의하기
*/
