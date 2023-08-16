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
			int m=line.length();
			char[] arr = new char[m];
			for (int i = 0; i < m-1; i++) {
				arr[i] = line.charAt(i);
				if (arr[i] == '(' && line.charAt(i + 1) == ')') {
					arr[i] = 'r';
					arr[i + 1] = 'c';
					i++;
				}
			}
			int sum = 0;
			int stk = 0;
			for (int i = 0; i < m-1; i++) {
				if (arr[i] == '(') {
					stk++;
					sum++;
				} else if (arr[i] == ')') {
					stk--;
				} else if (arr[i] == 'r') {
					sum += stk;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}