import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			String key = br.readLine();
			String line = br.readLine();
			char[] keyarr = key.toCharArray();
			char[] linearr = line.toCharArray();
			int cnt = 0;
			for (int i = 0; i < linearr.length - keyarr.length + 1; i++) {
				boolean flag = true;
				for (int j = 0; j < keyarr.length; j++) {
					if (linearr[i + j] != keyarr[j]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
/*
처음엔 cnt++로 접근하였으나
boolean flag를 활용하여 효율을 좀 더 높일 수 있었다.
*/
