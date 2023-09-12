import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bab = {"aya","ye","woo","ma"};
        
        for(int i=0; i< babbling.length;i++){
            
            for(int j=0;j<4;j++){
               babbling[i]=babbling[i].replace(bab[j],"_");
              }
            
            babbling[i]=babbling[i].replace("_","");
            if(babbling[i].isEmpty()) answer++;
            }
        return answer;
    }
}