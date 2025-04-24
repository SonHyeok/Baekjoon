import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visit = new boolean[n];  
        
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(i, computers, visit); // bfs가 한 번 호출될때마다 네트워크의 갯수 1개 추가
                answer++;
            } 
        }
        
        return answer;
    }
    
    static void bfs(int start, int[][] computers, boolean[] visit){
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작점 추가
        queue.offer(start);
        visit[start] = true;
        
         while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next = 0; next < computers[cur].length; next++){
                // 방문 기록이 없고, 연결된 컴퓨터가 있을 경우
                if(cur != next &&
                    !visit[next] && 
                    computers[cur][next] == 1){

                    // 방문 처리
                    visit[next] = true;

                    queue.offer(next);
                }
            }
        }
    }
}