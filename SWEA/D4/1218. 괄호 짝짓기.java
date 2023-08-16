import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                char currentChar = line.charAt(i);
                if (currentChar == '(') {
                    a++;
                } else if (currentChar == '[') {
                    b++;
                } else if (currentChar == '{') {
                    c++;
                } else if (currentChar == '<') {
                    d++;
                } else if (currentChar == ')') {
                    if (a == 0) {
                        flag = false;
                        break;
                    }
                    a--;
                } else if (currentChar == ']') {
                    if (b == 0) {
                        flag = false;
                        break;
                    }
                    b--;
                } else if (currentChar == '}') {
                    if (c == 0) {
                        flag = false;
                        break;
                    }
                    c--;
                } else if (currentChar == '>') {
                    if (d == 0) {
                        flag = false;
                        break;
                    }
                    d--;
                }
            }
            if (a != 0 || b != 0 || c != 0 || d != 0) {
                flag = false;
            }
            int ans = flag ? 1 : 0;
            System.out.println("#" + tc + " " + ans);
        }
    }
}
