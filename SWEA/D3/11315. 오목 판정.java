import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					char ch = line.charAt(j);
					map[i][j] = (ch == '.' ? 0 : 1);
				}
			}
			String ans = "NO";
			outerLoop: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 0)
						continue;
					for (int k = 0; k < 8; k++) {
						int nr = r + dr[k] * 4;
						int nc = c + dc[k] * 4;
						int cnt = 0;
						if (nr >= 0 && nr < N && nc >= 0 && nc < N)
							for (int i = 1; i <= 4; i++) {
								if (map[r + dr[k] * i][c + dc[k] * i] == 1)
									cnt++;
							}
						if (cnt == 4) {
							ans = "YES";
							break outerLoop;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ
*/
