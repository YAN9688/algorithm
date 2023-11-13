import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[0][0];
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + map[i - 1][0];
            dp[1][i] = dp[1][i - 1] + map[0][i - 1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = -dp[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] + map[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < m; tc++) {
            st = new StringTokenizer(br.readLine());
            int s_r = Integer.parseInt(st.nextToken());
            int s_c = Integer.parseInt(st.nextToken());
            int e_r = Integer.parseInt(st.nextToken());
            int e_c = Integer.parseInt(st.nextToken());

            sb.append(dp[e_r][e_c] + dp[s_r - 1][s_c - 1] - dp[e_r][s_c - 1] - dp[s_r - 1][e_c]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
