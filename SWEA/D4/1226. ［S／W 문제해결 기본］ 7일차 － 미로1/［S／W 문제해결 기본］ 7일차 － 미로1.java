import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] tf;
    static int answer;
    static int N = 16;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            tc = Integer.parseInt(br.readLine());
            int s_r = 0, s_c = 0;
            map = new int[N][N];
            tf = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = tmp.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        s_r = i;
                        s_c = j;
                    }
                }
            }
            answer = 0;
            fc(s_r, s_c);
            sb.append("#" + tc + " " + answer + "\n");

        }
        System.out.print(sb);
    }

    static void fc(int s_r, int s_c) {
        int nr = s_r;
        int nc = s_c;
        if (answer == 1)
            return;
        tf[s_r][s_c] = true;
        for (int d = 0; d < 4; d++) {
            nr = s_r + dr[d];
            nc = s_c + dc[d];

            if (nr < N && nc < N && nr >= 0 && nc >= 0 && !tf[nr][nc] && map[nr][nc] != 1) {
                if (map[nr][nc] == 3) {
                    answer = 1;
                    return;
                }
                fc(nr, nc);
            }
        }
    }
}