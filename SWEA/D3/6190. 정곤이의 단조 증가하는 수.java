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

/*
                    // Ai*Aj 값을 문자 배열로 바꾸기
                    char[] c = String.valueOf(arr[i] * arr[j]).toCharArray(); 
                     
                    // 단조증가하는 수인지 확인
                    for (int k = 0; k < c.length-1; k++)
                        if (c[k] > c[k+1]) continue j; 
                    이런방식도 생각해볼수있다.
                    Integer, String의 메소드에 대해서 공부를 좀 더 해봐야겠다.
*/
