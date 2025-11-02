// dfs + 백트래킹
import java.util.*;
class Solution {
    int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        
        return maxCount;
        
    }
    
    void dfs(int current, int[][] dungeons, boolean[] visited, int count){
        for(int i = 0; i < dungeons.length; i++){
            maxCount = Math.max(maxCount, count);
            if(!visited[i] && current >= dungeons[i][0]){
                visited[i] = true;
                dfs(current - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
    
    
    
}