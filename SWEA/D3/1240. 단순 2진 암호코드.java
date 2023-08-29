import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int bre = 0;
            int[] nums = new int[8];
            String str = null;
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                if (temp.contains("1")) {
                    for (int j = M - 1; j >= 55; j--) {
                        if (temp.charAt(j) == '1') {
                            str = temp.substring(j - (56 - 1), j + 1);
                            break;
                        }
                    }
                    bre = i;
                    break;
                }
            }
            int cnt = 0;
            for (int i = 0; i < 56; i += 7) {
                nums[cnt++] = conv(str.substring(i, i + 7));
            }
            int oddsum = 0;
            int evesum = 0;
            int sum = 0;
            for (int i = 0; i < 8; i += 2) {
                evesum += nums[i];
            }
            for (int i = 1; i < 8; i += 2) {
                oddsum += nums[i];
            }
            if ((oddsum + evesum * 3) % 10 == 0)
                sum = oddsum + evesum;
 
            for (int i = bre + 1; i < N; i++) {
                br.readLine();
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
    private static Map<String, Integer> mapping = new HashMap<>();
    static {
        mapping.put("0001101", 0);
        mapping.put("0011001", 1);
        mapping.put("0010011", 2);
        mapping.put("0111101", 3);
        mapping.put("0100011", 4);
        mapping.put("0110001", 5);
        mapping.put("0101111", 6);
        mapping.put("0111011", 7);
        mapping.put("0110111", 8);
        mapping.put("0001011", 9);
    }
    static int conv(String str) {
        return mapping.getOrDefault(str, -1);
    }
}
/*
-디버깅-
String의 메소드 substring은 endindex를 포함하지않는다.
예를들어, str.substring(i, i + 7)는 8개의 문자열이 반환되어야할 것 같지만, i+6번째 인덱스 문자까지 잘린다.
-최적화-
바로 배열을 만들지 말고 조건에 따라 가공 먼저 하기
HashMap 이용하기
*/
