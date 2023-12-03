import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        int answer = -1;
        int n=maps.length;
        int m=maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] pos =q.poll();
            int r=pos[0];
            int c=pos[1];
            if(r==n-1 && c==m-1){
                answer= pos[2];
                break;
            }
            for(int d=0;d<4;d++){
                int nr= r+dr[d];
                int nc= c+dc[d];
                if(nr<0 || nc<0 || nr>=n || nc>=m )
                    continue;
                if(visited[nr][nc] || maps[nr][nc]==0)
                    continue;
                q.add(new int[]{nr,nc,pos[2]+1});
                visited[nr][nc]=true;
            }
        }
        return answer;
    }
}