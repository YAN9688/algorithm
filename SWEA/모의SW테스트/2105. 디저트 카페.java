import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N, R, L, ans;
	static Set<Integer> set;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			set = new HashSet<>();
			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {
					for (int tot = (N - r - 1) * 2; tot >= 4; tot--) {
						if (tot <= ans)
							break;
						if (rotate(r, c, tot)) {
							ans = tot;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static boolean rotate(int r, int c, int tot) {
		int len1, len2;
		for (len1 = 1; len1 < (tot / 2); len1++) {
			len2 = tot / 2 - len1;
			set.clear();
			int nr = r;
			int nc = c;
			if (r + len1 + len2 >= N || c - len2 < 0 || c + len1 >= N)
				continue;
			for (int d = 0; d < 4; d++) {
				int len = (d % 2 == 0) ? len1 : len2;
				for (int j = 0; j < len; j++) {
					set.add(map[nr][nc]);
					nr += dr[d];
					nc += dc[d];
				}
			}
			if (set.size() == tot) {
				return true;
			}
		}
		return false;
	}
}
/*
set을 매번 만들지 말고 clear라는 메서드가 있었다.
가지치기를 하기 위해 row가 작은 값부터, tot이 최대인 값부터 탐색을 시작하였다.
현재의 최대값 ans보다 tot이 작은 경우 바로 넘어가도록 구현

len1 과 len2가 정해진 순간 꼭지점 값만 인덱스에 벗어나지 않는지 확인하면 된다는 사실을 깨닫고
인덱스 설정을 반복문안에 넣지않고 수정하였다.
			if (r + len1 + len2 >= N || c - len2 < 0 || c + len1 >= N)
				continue;
    >>그랬더니 최적화가 잘됨

    생각해보니 tot을 1씩이 아니라 2씩 빼줘야했음

최종
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N, ans;
	static Set<Integer> set;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			set = new HashSet<>();
			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {
					for (int tot = (N - r - 1) * 2; tot >= 4; tot -= 2) {
						if (tot <= ans)
							break;
						if (rotate(r, c, tot)) {
							ans = tot;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static boolean rotate(int r, int c, int tot) {
		int len1, len2;
		for (len1 = 1; len1 < (tot / 2); len1++) {
			len2 = tot / 2 - len1;
			set.clear();
			int nr = r;
			int nc = c;
			if (r + len1 + len2 >= N || c - len2 < 0 || c + len1 >= N)
				continue;
			for (int d = 0; d < 4; d++) {
				int len = (d % 2 == 0) ? len1 : len2;
				for (int j = 0; j < len; j++) {
					set.add(map[nr][nc]);
					nr += dr[d];
					nc += dc[d];
				}
			}
			if (set.size() == tot) {
				return true;
			}
		}
		return false;
	}
}
