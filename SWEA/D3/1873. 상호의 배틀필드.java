import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] hw = br.readLine().split(" ");
            int H = Integer.parseInt(hw[0]);
            int W = Integer.parseInt(hw[1]);
            char[][] map = new char[H][W];
            int r = 0;
            int c = 0;
            for (r = 0; r < H; r++) {
                char[] rowChars = br.readLine().toCharArray();
                for (c = 0; c < W; c++) {
                    map[r][c] = rowChars[c];
                }
            }
            o: for (r = 0; r < H; r++) {
                for (c = 0; c < W; c++) {
                    if (map[r][c] != '.' && map[r][c] != '*' & map[r][c] != '#' & map[r][c] != '-') {
                        break o;
                    }
                }
            }
            int last_state = 0;
            if (map[r][c] == '^')
                last_state = 1;
            else if (map[r][c] == 'v')
                last_state = 2;
            else if (map[r][c] == '<')
                last_state = 3;
            else if (map[r][c] == '>')
                last_state = 4;
            map[r][c] = '.';
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                char temp = str.charAt(i);
                if (temp == 'U') {
                    last_state = 1;
                    if (r - 1 >= 0 && map[r - 1][c] == '.') {
                        r--;
                    }
                } else if (temp == 'D') {
                    last_state = 2;
                    if (r + 1 < H && map[r + 1][c] == '.') {
                        r++;
                    }
                } else if (temp == 'L') {
                    last_state = 3;
                    if (c - 1 >= 0 && map[r][c - 1] == '.') {
                        c--;
                    }
                } else if (temp == 'R') {
                    last_state = 4;
                    if (c + 1 < W && map[r][c + 1] == '.') {
                        c++;
                    }
                } else if (temp == 'S') {
                    if (last_state == 1) {
                        for (int j = 0; j <= r; j++) {
                            if (map[r - j][c] == '*') {
                                map[r - j][c] = '.';
                                break;
                            } else if (map[r - j][c] == '#') {
                                break;
                            }
                        }
                    } else if (last_state == 2) {
                        for (int j = 0; j < H - r; j++) {
                            if (map[r + j][c] == '*') {
                                map[r + j][c] = '.';
                                break;
                            } else if (map[r + j][c] == '#') {
                                break;
                            }
                        }
                    } else if (last_state == 3) {
                        for (int j = 0; j <= c; j++) {
                            if (map[r][c - j] == '*') {
                                map[r][c - j] = '.';
                                break;
                            } else if (map[r][c - j] == '#') {
                                break;
                            }
                        }
                    } else if (last_state == 4) {
                        for (int j = 0; j < W - c; j++) {
                            if (map[r][c + j] == '*') {
                                map[r][c + j] = '.';
                                break;
                            } else if (map[r][c + j] == '#') {
                                break;
                            }
                        }
                    }
                }
            }
            if (last_state == 1)
                map[r][c] = '^';
            else if (last_state == 2)
                map[r][c] = 'v';
            else if (last_state == 3)
                map[r][c] = '<';
            else if (last_state == 4)
                map[r][c] = '>';
            pw.print("#" + tc + " ");
            for (char[] row : map) {
                pw.println(row);
            }
        }
        pw.flush();
        pw.close();
    }
}

/*
-궁금-
scanner에서 string을 받아서 char로 자르는 거 말고 그냥 char씩 받는 방법은 없나?
-최적화-
처음 탱크 위치 찾기. 변수 굳이 두지 말고 rc로 돌고 바로 break
현재 탱크에 대해서 방향만 저장하기
*/
