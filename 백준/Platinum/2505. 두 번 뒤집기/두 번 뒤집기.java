import java.util.*;

public class Main {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
		}
		int[] arr_reset = arr.clone();
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt >= 2) {
				break;
			}
			if (check())
				break;
			if (arr[i] != i) {
				for (int j = i + 1; j <= n; j++) {
					if (arr[j] == i) {
						sb.append(i + " " + j + "\n");
						swap(i, j);
						cnt++;
						break;
					}
				}
			}
		}
		if (check() &&cnt == 0) {
			System.out.println(1 + " " + 1 + "\n" + 1 + " " + 1);
		} else if (check() &&cnt == 1) {
			sb.append(1 + " " + 1 + "\n");
			System.out.println(sb.toString());
		} else if (check() &&cnt == 2) {
			System.out.println(sb.toString());
		} else {
			sb = new StringBuilder();
			cnt = 0;
			arr = arr_reset;
			for (int i = n; i > 0; i--) {
				if (cnt >= 2) {
					break;
				}
				if (check())
					break;
				if (arr[i] != i) {
					for (int j = i - 1; j > 0; j--) {
						if (arr[j] == i) {
							sb.append(j + " " + i + "\n");
							swap(j, i);
							cnt++;
							break;
						}
					}
				}
			}
			System.out.println(sb.toString());
		}
	}

	static void swap(int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static boolean check() {
		for (int i = 1; i <= n; i++) {
			if (arr[i] != i)
				return false;
		}
		return true;
	}
}
