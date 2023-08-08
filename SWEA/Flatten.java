import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int[] a = new int[100];
			int m= sc.nextInt();
			int d =-1;
			for(int i=0;i<100;i++) {
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			while(m>0) {
				if(a[99]-a[0]<=1)
					break;
				m --;
				a[99]--;
				a[0]++;
				Arrays.sort(a);
			}
			d= a[99]-a[0];
			System.out.println("#" + test_case + " " + d);
		}
	}
}
