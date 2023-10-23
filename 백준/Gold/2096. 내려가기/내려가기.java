import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		int[][] score = new int[N][3];
		int[][] dpmax = new int[N][3];
		int[][] dpmin = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				score[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		for (int i = 0; i < 3; i++) {
			dpmax[N - 1][i] = dpmin[N - 1][i] = score[N - 1][i];
		}

		for (int i = N - 2; i >= 0; i--) {
			int a = Math.max(dpmax[i + 1][0], dpmax[i + 1][1]);
			int b = Math.max(dpmax[i + 1][1], dpmax[i + 1][2]);
			dpmax[i][0] = score[i][0] + a;
			dpmax[i][1] = score[i][1] + Math.max(a, b);
			dpmax[i][2] = score[i][2] + b;
			
			int c= Math.min(dpmin[i + 1][0], dpmin[i + 1][1]);
			int d =Math.min(dpmin[i + 1][1], dpmin[i + 1][2]);

			dpmin[i][0] = score[i][0] + c;
			dpmin[i][1] = score[i][1] + Math.min(c,d);
			dpmin[i][2] = score[i][2] + d;
		}

		bw.write(Math.max(dpmax[0][0], Math.max(dpmax[0][1], dpmax[0][2])) + " "
				+ Math.min(dpmin[0][0], Math.min(dpmin[0][1], dpmin[0][2])));

		bw.flush();
		bw.close();
		br.close();
	}
}
