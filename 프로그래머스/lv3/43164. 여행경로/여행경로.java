import java.util.*;
class Solution {
    StringBuilder sb = new StringBuilder();
    boolean[] used;
    String ans = "Z";
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        sb.append("ICN ");
        dfs(0,"ICN", tickets);
        String[] answer = ans.split(" ");
        return answer;
    }
    public void dfs(int len, String start, String[][] tickets) {
        if (len==tickets.length) {
        	if (ans.compareTo(sb.toString()) > 0) {
        	    ans = sb.toString();
        	}
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(start)) {
                used[i] = true;
                sb.append(tickets[i][1]).append(" ");
                dfs(len+1, tickets[i][1], tickets);
                used[i] = false;
                sb.delete(sb.length()-4, sb.length());
            }
        }
    }
}