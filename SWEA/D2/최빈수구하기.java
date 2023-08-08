import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int[] arr = new int[101];
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}
			int max = 0;
			int max_i = 0;
			for (int i = 100; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
					max_i = i;
				}
			}
			System.out.println("#" + num + " " + max_i);
		}
	}
}
/*
arr[sc.nextInt()] - index에 바로 받을 생각
*/
