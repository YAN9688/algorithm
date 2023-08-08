import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int[] a = new int[100];
			int m = sc.nextInt();
			int d = -1;
			for (int i = 0; i < 100; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			while (m > 0) {
				if (a[99] - a[0] <= 1)
					break;
				m--;
				a[99]--;
				a[0]++;
				Arrays.sort(a);
			}
			d = a[99] - a[0];
			System.out.println("#" + test_case + " " + d);
		}
	}
}
/*
loop의 매 시행마다
Array를 sort하는 것과, MAX-MIN을 구하고 각각의 INDEX 탐색하는 것 중 어느 것이 더 효율적일지 고민해보았다. 연산량에 대해 조금 더 공부해 봐야겠다.

왜인지 모를 논리 오류에 당황했다.
loop 안에서 sort 후 move 하는것과
sort 후 loop 안에서 move 후 다시 sort 하는 과정이
다를게 없어야 하는데 이상하게 output이 다르게 나왔고
뭔가 답이 안나오면 이런과정을 거쳐보는 것도 좋을것같다.
*/
