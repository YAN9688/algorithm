import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int target = sc.nextInt();
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
		}
		long x_min = 1;
		long x_max = Arrays.stream(arr).max().getAsInt();
		long find_x = 0;

		while (x_min <= x_max) {
			long num = 0;
			long x = (x_min + x_max) / 2;
			for (int i = 0; i < k; i++) {
				num += arr[i] / x;
			}
			if (num >= target) {
				find_x = x;
				x_min = x + 1;
			} else {
				x_max = x - 1;
			}
		}

		System.out.println(find_x);

	}
}