import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb;
	static boolean[] sel;
	static HashSet<String> set;
	static HashSet<Integer> arr;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new HashSet<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		list = new ArrayList<>(arr);
		Collections.sort(list);
		sb = new StringBuilder();
		sel = new boolean[n];
		set = new HashSet<>();
		comb(0, 0, new StringBuilder());
		System.out.println(sb.toString());
	}

	static void comb(int len, int idx, StringBuilder tmp) {
		if (len == m) {
			sb.append(tmp + "\n");
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			StringBuilder next = new StringBuilder(tmp);
			comb(len + 1, i, next.append(list.get(i) + " "));
		}
	}
}