import java.util.Scanner;
 
class Solution {
    public static int N;
    public static int L;
    public static int[][] rcp;
    public static boolean[] tak;
    public static int maxi;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();
            rcp = new int[N][2];
            tak = new boolean[N];
            maxi=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    rcp[i][j] = sc.nextInt();
                }
            }
            com(0);
            System.out.println("#" + tc + " " + maxi);
        }
    }
 
    public static void com(int idx) {
        if (idx == N) {
            int cnt = 0;
            int lim = 0;
            for (int i = 0; i < N; i++) {
                if (tak[i]) {
                    cnt += rcp[i][0];
                    lim += rcp[i][1];
                }
            }
            if (lim <= L)
                maxi = Math.max(cnt, maxi);
            return;
        }
        tak[idx] = false;
        com(idx + 1);
        tak[idx] = true;
        com(idx + 1);
    }
}
/*
부분조합 입문
비트연산자로도 시도해보기~
*/
