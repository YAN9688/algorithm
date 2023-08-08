import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 2; i < N - 2; i++) {
				if (arr[i] > arr[i - 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
					cnt++;
					while (arr[i] > 0) {
						arr[i]--;
						if (arr[i] > arr[i - 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2])
							cnt++;
						else
							break;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
