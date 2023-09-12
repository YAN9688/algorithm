import java.util.*;
class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int N =nums.length;
        int[] num = new int[N];
        
        for(int i=0; i<N;i++){
            num[i]= Integer.parseInt(nums[i]);
        }
        
        Arrays.sort(num);
        String answer = num[0] +" "+num[N-1];
        return answer;
    }
}