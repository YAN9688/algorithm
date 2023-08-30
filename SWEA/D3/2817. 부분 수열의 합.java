import java.util.Scanner;
 
class Solution{
    public static int N;
    public static int K;
    public static int[] num;
    public static boolean[] set;
    public static int cnt;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            num = new int[N];
            set = new boolean[N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }
            fc(0);
            System.out.println("#" + tc + " " + cnt);
        }
    }
 
    public static void fc(int idx) {
        if (idx == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (set[i])
                    sum += num[i];
            }
            if (sum == K)
                cnt++;
            return;
        }
        set[idx] = false;
        fc(idx + 1);
        set[idx] = true;
        fc(idx + 1);
    }
}
