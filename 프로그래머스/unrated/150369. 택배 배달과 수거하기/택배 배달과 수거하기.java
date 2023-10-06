import java.util.*;
class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int[] del_sum = new int[n];
		int[] pic_sum = new int[n];
		int len = n;
		del_sum[0]= deliveries[0];
		pic_sum[0]= pickups[0];
		for (int i = 1; i < n; i++) {
			del_sum[i] = del_sum[i-1]+ deliveries[i];
			pic_sum[i] = pic_sum[i-1]+ pickups[i];
		}
		int del_tmp = del_sum[n - 1];
		int pic_tmp = pic_sum[n - 1];
		int del_len = n;
		int pic_len = n;

		while (del_tmp > 0 || pic_tmp > 0) {
			if (del_tmp > 0) {
				for (int i = del_len - 1; i >= 0; i--) {
					if (del_sum[i] < del_tmp) {
						del_len = i + 2;
						break;
					}del_len=1;
				}
			} else
				del_len = 0;
			if (pic_tmp > 0) {
				for (int i = pic_len - 1; i >= 0; i--) {
					if (pic_sum[i] < pic_tmp) {
						pic_len = i + 2;
						break;
					}pic_len=1;
				}
			} else
				pic_len = 0;
			len = Math.max(del_len, pic_len);
			answer += 2 * len;
			del_tmp -= cap;
			pic_tmp -= cap;
		}
		return answer;
	}
}