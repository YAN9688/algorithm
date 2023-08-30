import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
	public static int N;
	public static int[][] bd;
	public static int[] sl;
	public static int[] sx;
	public static int totsum;
	public static int mini;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			bd = new int[N][N];
			sl = new int[N / 2];
			sx = new int[N / 2];
			mini = Integer.MAX_VALUE;
			totsum = 0;
			for (int i = 0; i < N; i++) {
				String[] tempLine = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(tempLine[j]);
					bd[i][j] = temp;
					totsum += temp;
				}
			}
			fc(0, 0);
			System.out.println("#" + tc + " " + mini);
		}
	}

	public static void fc(int idx, int sidx) {
		if (sidx == N / 2) {
			int s1 = 0;
			int s2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					s1 += bd[sl[i]][sl[j]];
				}
			}
			for (int i = 0, k = 0; i < N; i++) {
				if (k < N / 2 && sl[k] == i) {
					k++;
					continue;
				}
				for (int j = 0, l = 0; j < N; j++) {
					if (l < N / 2 && sl[l] == j) {
						l++;
						continue;
					}
					s2 += bd[i][j];
				}
			}
			mini = Math.min(Math.abs(s2 - s1), mini);
			return;
		}
		for (int i = idx; i <= (N / 2) + sidx; i++) {
			sl[sidx] = i;
			fc(i + 1, sidx + 1);
		}
	}
}

/*
조합을 만드는 두가지 방법중에서 반복문을 이용하는 것... 정말 이해가 어려웠다.
그리고 조합을 짠 다음에, 남겨진 원소를 선택하는 것을 간단하게 하는게 또 정말 어려웠다.
			for (int i = 0, k = 0; i < N; i++) {
				if (k < N / 2 && sl[k] == i) {
					k++;
					continue;
				}
				for (int j = 0, l = 0; j < N; j++) {
					if (l < N / 2 && sl[l] == j) {
						l++;
						continue;
					}
					s2 += bd[i][j];
				}
			}
이 코드는 나름 킥이었던 것 같다.
최적화를 위해 이미 한번 뽑은 조합의 반대쪽을 다시 뽑지 않게 구현하고싶었는데,
예를들어 (12를뽑았으면 34는 자동으로 만들어진 조합이므로
34를 다시 뽑지 않게 만드는것)
이 과정이 꽤나 어려워서 시간이 모자라서 하지못했다. 담에 해볼것
*/
