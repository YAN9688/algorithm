import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc < 10) {
			tc = sc.nextInt();
			int[][] map = new int[100][102];
			for (int r = 0; r < 100; r++) {
				for (int c = 1; c <= 100; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			int t_c = 0;

			for (int c = 1; c <= 100; c++) {
				if (map[99][c] == 2) {
					t_c = c;
					break;
				}
			}
			int r = 99;
            while (r > 0) {

                if (map[r][t_c - 1] == 1) {
                    int i = 0;
                    while (true) {
                        i++;
                        if (map[r][t_c - i] == 0)
                            break;
                    }
                    t_c = t_c - (i - 1);
                    r--;
                } else if (map[r][t_c + 1] == 1) {
                    int i = 0;
                    while (true) {
                        i++;
                        if (map[r][t_c + i] == 0)
                            break;
                    }
                    t_c = t_c + (i - 1);
                    r--;
                } else
                    r--;
            }
            int fc = t_c - 1;
            System.out.println("#" + tc + " " + fc);
        }
    }
}
/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
디버그에 시간이 걸렸던 과정: 사다리 옆으로 이동하는 과정이 한번에 이루어지는 것이 아니라는 것을 간과했다. 사다리의 가로 길이도 천차만별인것을!
input데이터가 적혀있는 칸을 유심히 보면서 알고리즘대로 움직여보다가 깨달았다.
막히는 일이 있으면 꼭 이런식으로 문제를 다시 바라볼 것.
*/


/*훨씬 깔끔한 코드 만들어보기*/
			int r = 99;
			int c;
			for (c = 1; c <= 100; c++) {
				if (map[99][c] == 2)
					break;
			}
			while (r > 0) {
				if (map[r][c - 1] == 1) {
					while (map[r][c - 1] == 1)
						c--;
				} else if (map[r][c + 1] == 1) {
					while (map[r][c + 1] == 1) {
						c++;
					}
				}
				r--;
			}
			System.out.println("#" + tc + " " + (c - 1));
		}
