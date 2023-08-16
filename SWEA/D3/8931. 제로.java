import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			for(int i=0;i<K;i++) {
				int tmp=sc.nextInt();
				if(tmp!=0)
				st.push(tmp);
				else st.pop();
			}
			int sum = 0;
	        for (int value : st) {
	            sum += value;
	        }
			System.out.println("#" + tc + " " + sum);
		}
	}
}
