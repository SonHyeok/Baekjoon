// 현재 피로도에서 탐색 가능한 요구 피로도가 가장 높은 던전 우선 탐색,
// 이후 
import java.util.*;
class Solution {
    int maxCount = 0;    

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int count = 0;
        
        dfs(k, visited, count, dungeons);
        
        return maxCount;
    }
    
    void dfs(int current, boolean[] visited, int count, int[][] dungeons){
        maxCount = Math.max(maxCount, count);
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i] && dungeons[i][0] <= current){
                visited[i] = true;
                
                dfs(current - dungeons[i][1], visited, count + 1, dungeons);
                
                visited[i] = false;
            }
        }
        
        
    }
}