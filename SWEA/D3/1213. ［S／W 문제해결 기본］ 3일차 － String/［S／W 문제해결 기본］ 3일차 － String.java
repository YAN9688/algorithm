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
			int cnt = 0;
			for (int i = 0; i < line.length() - key.length() + 1; i++) {
				boolean flag = true;
				for (int j = 0; j < key.length(); j++) {
					if (line.charAt(i+j)!= key.charAt(j)) {
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