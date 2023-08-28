import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int max = -1;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int current = arr[i] * arr[j];
                    if (current < 10) {
                        max = Math.max(current, max);
                    } else {
                        String b = Integer.toString(current);
                        boolean flag = true;
                        for (int k = 0; k < b.length() - 1; k++) {
                            if (b.charAt(k) - b.charAt(k + 1) > 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            max = Math.max(current, max);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
