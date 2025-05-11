// 문자를 비교해서 다른 문자의 숫자가 1개인 경우에만 변경 가능하다고 판단
// 
import java.util.*;
class Solution {
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        visit = new boolean[words.length];

        dfs(begin, target, words,0);
        
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    static void dfs(String now, String target, String[] words, int count){        
            if(now.equals(target)) {
                answer = Math.min(answer,count);
                return;
            }
        
            for(int i = 0; i < words.length; i++){
                if(!visit[i] && canChange(now, words[i])){
                    visit[i] = true;
                    dfs(words[i], target, words, count + 1);
                    visit[i] = false;
                }
            }
    }
    
    static boolean canChange(String current, String next){
        int diff = 0;
        for(int i = 0; i < current.length(); i++) {
            if(current.charAt(i) != next.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}