import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n ; i++){
            if(visited[i]) continue;
            answer++;
            Queue<Integer> q = new LinkedList<>();
              q.add(i);
             visited[i] =true;
             while(!q.isEmpty()){
               int tmp = q.poll();
               for(int j=0; j<n; j++){
                if(!visited[j] && computers[tmp][j]==1){
                q.add(j);
                visited[j]=true;
                }
            }
        }
        }
        return answer;
    }

}