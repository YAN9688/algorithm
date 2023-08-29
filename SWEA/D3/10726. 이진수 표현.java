import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if ((M & (1 << i)) == 0) {
                    flag = false;
                    break;
                }
            }
            System.out.println("#" + tc + " " + (flag ? "ON" : "OFF"));
        }
    }
}

/*
if ((M & (1 << i)) == 0)
비트 연산에 대한 이해도를 만들기 좋은 문제였다. 조금 더 공부해 볼  필요가 있음.
처음 접근 방법은 2^N-1이 N개의 1로만 구성되어있어서 이걸 비교해보는 방식으로 도전하려 했는데 방향을 바꿨다. 
위 방법으로도 다시 시도해보면 좋을 것 같다.
&연산을 ^ (XOR)로도 했었는데 잘안됐었다. 이부분에 대해 탐색해보자.
*/
