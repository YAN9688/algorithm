import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int test_case = Integer.parseInt(br.readLine());
            int N = 100;
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = tmp[j];
                }
            }
            int max = 1;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int len = 1;
                    int i = 0;
                    int j = 0;
                    int k = 0;
                    int m = 0;
                    while (r - i >= 0 && r + 1 + i < N && map[r - i][c] == map[r + 1 + i][c]) {
                        i++;
                    }
                    len = 2 * i;
                    max = Math.max(max, len);
                    while (r - j >= 0 && r + j < N && map[r - j][c] == map[r + j][c]) {
                        j++;
                    }
                    len = 2 * j - 1;
                    max = Math.max(max, len);
                    while (c - k >= 0 && c + 1 + k < N && map[r][c - k] == map[r][c + 1 + k]) {
                        k++;
                    }
                    len = 2 * k;
                    max = Math.max(max, len);
                    while (c - m >= 0 && c + m < N && map[r][c - m] == map[r][c + m]) {
                        m++;
                    }
                    len = 2 * m - 1;
                    max = Math.max(max, len);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}