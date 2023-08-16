import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			char[] arr = new char[line.length()];

			for (int i = 0; i < line.length(); i++) {
				arr[i] = line.charAt(i);
				if (arr[i] == '(' && i + 1 < line.length() && line.charAt(i + 1) == ')') {
					arr[i] = 'r';
					arr[i + 1] = 'c';
					i++;
				}
			}
			int sum = 0;
			int stk = 0;
			for (int i = 0; i < line.length(); i++) {
				if (arr[i] == '(') {
					stk++;
					sum++;
				} else if (arr[i] == ')') {
					stk--;
				} else if (stk > 0 && arr[i] == 'r') {
					sum += stk;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
/*
Stack 수업을 배운 직후라 stack으로 먼저 접근해서 풀었는데
굳이 stack을 쓰지 않아도 더 효율적인 코드를 만들 수 있길래 수정해보았다.
*/
