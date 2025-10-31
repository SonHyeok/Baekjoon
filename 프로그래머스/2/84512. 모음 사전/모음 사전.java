import java.util.*;

class Solution {
    String[] words = new String[]{"A","E","I","O","U"};
    int count = 0;
    boolean found = false;
    
    public int solution(String word) {        
        
        dfs(word, "");
        
        return count;
    }
    
    void dfs(String word, String cur){
        // 목표 단어 찾은 경우
        if(found) return; 
                
        // 목표 단어가 아니며, 사전에 추가해야 할 단어인 경우
        if (!cur.isEmpty()) {
            count++;
            if (cur.equals(word)) {
                found = true;
                return;
            }
        }
 
        if(cur.length() == 5) return;
        
        for(int i = 0; i < 5; i++){
            dfs(word, cur + words[i] );
        }
             
    }
}