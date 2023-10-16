import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] map;
    static int[] ordered; // 순열 배열
    static boolean[] sel;// 순열 선택 시 방문 배열
    static boolean[][][] visited;
    static int[] dz = {1, 0, 0, 0, 0, -1};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int mini;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5][5];
        ordered = new int[5];
        sel = new boolean[5];
        mini = Integer.MAX_VALUE;

        for (int z = 0; z < 5; z++) {
            for (int y = 0; y < 5; y++) {
                String[] row = br.readLine().split(" ");
                for (int x = 0; x < 5; x++) {
                    map[z][y][x] = Integer.parseInt(row[x]);
                }
            }
        }

        per(0);

        if (mini == Integer.MAX_VALUE)
            mini = -1;

        System.out.println(mini);
    }

    static void per(int idx) {
        if (idx == 5) {
            int[][][] tmp_map = new int[5][5][5];
            for (int m0 = 0; m0 < 4; m0++) {
                tmp_map[0] = rotate(map[ordered[0]], m0);
                for (int m1 = 0; m1 < 4; m1++) {
                    tmp_map[1] = rotate(map[ordered[1]], m1);
                    for (int m2 = 0; m2 < 4; m2++) {
                        tmp_map[2] = rotate(map[ordered[2]], m2);
                        for (int m3 = 0; m3 < 4; m3++) {
                            tmp_map[3] = rotate(map[ordered[3]], m3);
                            for (int m4 = 0; m4 < 4; m4++) {
                                tmp_map[4] = rotate(map[ordered[4]], m4);
                                check(tmp_map);
                            }
                        }
                    }
                }
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (sel[i])
                continue;
            sel[i] = true;
            ordered[idx] = i;
            per(idx + 1);
            sel[i] = false;
        }
    }

    static void check(int[][][] tmp_map) {
        visited = new boolean[5][5][5];
        Queue<Integer[]> q = new LinkedList<>();
        if (tmp_map[0][0][0] == 0 || tmp_map[4][4][4] == 0)
            return;
        q.add(new Integer[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Integer[] pos = q.poll();
            int z = pos[0];
            int y = pos[1];
            int x = pos[2];
            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= 5 || ny >= 5 || nx >= 5)
                    continue;
                if (tmp_map[nz][ny][nx] == 0 || visited[nz][ny][nx])
                    continue;
                if (nz == 4 && ny == 4 && nx == 4) {
                    mini = Math.min(mini, pos[3] + 1);
                    return;
                }
                visited[nz][ny][nx] = true;
                q.add(new Integer[]{nz, ny, nx, pos[3] + 1});
            }
        }
    }

    static int[][] rotate(int[][] layer_map, int time) {
        int[][] tmp = new int[5][5];
        if (time == 0) {
            return layer_map;
        } else if (time == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    tmp[i][j] = layer_map[j][4 - i];
                }
            }
        } else if (time == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    tmp[i][j] = layer_map[4 - i][4 - j];
                }
            }
        } else if (time == 3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    tmp[i][j] = layer_map[4 - j][i];
                }
            }
        }
        return tmp;
    }
}
