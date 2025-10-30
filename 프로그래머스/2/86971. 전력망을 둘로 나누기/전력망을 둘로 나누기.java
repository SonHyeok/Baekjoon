import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int[][] graph = new int[n + 1][n + 1];
        int minCount = 999;
        
        // 그래프 생성 및 초기화
        for(int[] wire : wires){
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        // 하나씩 연결 끊어가며 각 네트워크의 송전탑 갯수 측정
        for(int[] wire : wires){
            // 연결 끊기
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;

            boolean[] visited = new boolean[n + 1];
            
            // 한쪽 송전탑 갯수 측정
            int count = dfs(graph, visited, wire[0], n);
            
            // 한 쪽 송전탑의 갯수 - 다른 한 쪽 송전탑의 갯수 = 갯수 차이
            // n - count가 측정하지 않은 다른 한 쪽의 송전탑 갯수
            // count = 측정한 한 쪽의 송전탑 갯수
            int diff = Math.abs((n - count) - count);
            
            // 연결 복구
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
            
            minCount = Math.min(minCount, diff);
        }
        
        return minCount;
    }
    
    int dfs(int[][] graph, boolean[] visited, int node, int n){
        visited[node] = true;
        int count = 1;
        
        for(int i = 1; i <= n; i++){
            if(graph[node][i] == 1 && !visited[i]){
                count += dfs(graph, visited, i, n);
            }
        }
        
        return count;
    }
}