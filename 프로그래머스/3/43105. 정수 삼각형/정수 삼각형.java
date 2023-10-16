import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }
        for (int r = N - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                dp[r][c] = triangle[r][c] + Math.max(dp[r+1][c], dp[r+1][c+1]);
            }
        }
        return dp[0][0];
    }
}
