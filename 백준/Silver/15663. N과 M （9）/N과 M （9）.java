import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb;
	static boolean[] sel;
	static int[] arr;
	static HashSet<String> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		sel = new boolean[n];
		set = new HashSet<>();
		comb(0, new StringBuilder());
		System.out.println(sb.toString());
	}

	static void comb(int len, StringBuilder tmp) {
		if (len == m) {
			//set에 stringbuilder 객체를 넣으면 의도대로 답이 나오지않는다.
			//가변 객체이기 때문에 넣고나서 수정하면 변하기 때문...!
			if (!set.add(tmp.toString()))
				return;
			sb.append(tmp + "\n");
			return;

		}
		for (int i = 0; i < n; i++) {
			if (sel[i])
				continue;
			sel[i] = true;
			StringBuilder nextmp = new StringBuilder(tmp);
			comb(len + 1, nextmp.append(arr[i] + " "));
			sel[i] = false;
		}
	}
}