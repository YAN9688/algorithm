import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		if (N == 1) {
			System.out.println("A");
		} else if (N == 2) {
			if (nums[0] == nums[1])
				System.out.println(nums[0]);
			else
				System.out.println("A");
		} else {
			int a = 0;
			if (nums[1] - nums[0] != 0) {
				a = (nums[2] - nums[1]) / (nums[1] - nums[0]);
			}
			int b = nums[1] - a * nums[0];
			boolean flag = true;
			for (int i = 0; i < N - 1; i++) {
				if (nums[i + 1] != nums[i] * a + b) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println(nums[N - 1] * a + b);
			else
				System.out.println("B");
		}

	}
}
