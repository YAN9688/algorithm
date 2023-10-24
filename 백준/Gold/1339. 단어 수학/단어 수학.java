import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				alpha[tmp.charAt(j) - 'A'] += Math.pow(10, tmp.length() - 1 - j);
			}
		}
		Arrays.sort(alpha);
		int answer = 0;
		int k = 9;
		for (int i = 25; i > 15; i--) {
			answer += alpha[i] * (k--);
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
