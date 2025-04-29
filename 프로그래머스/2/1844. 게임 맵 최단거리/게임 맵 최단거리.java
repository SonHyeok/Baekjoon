import java.util.*;
class Solution {
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    
    static boolean[][] visit;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int m = maps.length;
        int n = maps[0].length;
        visit = new boolean[m][n];    
        
        answer = bfs(0,0,maps, m, n);
        
        return answer;
    }
    
    static int bfs(int x, int y, int[][] maps, int m, int n){
        Queue<Integer[]> queue = new LinkedList<>();
        
        // 현재까지의 이동 횟수
        int curCount = 0;
        
        // 시작점 추가
        queue.offer(new Integer[]{0,0});
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            
            // 현재 점
            Integer[] now = queue.poll();
            
            int cx = now[0];
            int cy = now[1];
            
            curCount = maps[cx][cy]; // 현재까지의 이동 횟수
            
            // 마지막 점에 도착한 경우 현재까지의 이동 횟수 반환
            if(cx == (m - 1) && cy == (n - 1)) return curCount;
            
            for(int i = 0; i < 4; i++){
                
                // 다음 이동할 상,하,좌,우
                int nx = cx+ dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(maps[nx][ny] == 1 && !visit[nx][ny]){
                        // 다음 방문할 점 추가 후, 방문 기록
                        queue.offer(new Integer[]{nx,ny});
                        maps[nx][ny] = curCount + 1; // 다음 방문할 점에 이동 횟수 기록
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        
        return -1;
            
    }
}