import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int N = players.length;
        int M = callings.length;
        HashMap<String,Integer> rank= new HashMap<>();

        for(int p=0; p<N; p++){
            rank.put(players[p],p);
            }
        
        for(String player : callings){
            int p_rank = rank.get(player);
            String p_foward = players[p_rank-1];
            
            players[p_rank-1]=player;
            players[p_rank]=p_foward;
            
            rank.put(player,p_rank-1);
            rank.put(p_foward, p_rank);
        }
            
        
        return players;
    }
}