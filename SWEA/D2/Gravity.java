import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int m = 0;
			int d = 0;
			for (int i = 0; i < n; i++) {
				d = n - i;
				for (int j = 0; j < n; j++) {
					if (arr[i] <= arr[j])
						d--;
				}
				m = Math.max(m, d);
			}
			System.out.println("#" + test_case + " " + m);
		}
	}
}
/*
평면에 대해서 무작정 2차원 배열로 생각하지 말기. index를 하나의 축으로 사용하는게 더 편할 수도 있다는 것을 생각하자!
*/
