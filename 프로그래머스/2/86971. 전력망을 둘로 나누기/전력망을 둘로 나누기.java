import java.util.*;

// 그래프 형태 생성
// 하나씩 연결을 끊어보면서 끊은 이후 두 쪽으로 나눠진 전력망 중에서, 한 쪽의 갯수 측정
// 이후 전체 갯수에서 측정된 갯수를 빼고 나머지 한 쪽의 갯수를 빼서 최솟값 측정
class Solution {
    public int solution(int n, int[][] wires) {
    
        int[][] graph = new int[n + 1][n + 1];
        int min = 999;
        
        // 그래프 생성
        for(int[] wire : wires){
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        for(int[] wire: wires){
            boolean[] visited = new boolean[n + 1];
                
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;
            
            int cur = dfs(graph, visited, wire[0]);
            
            int diff = Math.abs((n - cur) - cur);
            min = Math.min(min, diff);
            
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        } 
        
        return min;
    }
    
    int dfs(int[][] graph, boolean[] visited, int node){
        visited[node] = true;
        int count = 1;
        
        for(int i = 1; i < graph.length; i++){
            if(graph[node][i] == 1 && !visited[i]){
                count += dfs(graph, visited, i);
            }
        }
        
        return count;
    }
}