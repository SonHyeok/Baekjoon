// SJF 스케줄러 사용 문제

// 작업의 소요 시간이 더 짧고, 먼저 요청이 들어온 순서대로 정렬
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        // 요청 시간 기준 오름차순 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 작업 시간 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int currentTime = 0;
        int idx = 0;
        int count = 0;
        int total = 0;
        
        while(count < jobs.length){
            while(idx < jobs.length && currentTime >= jobs[idx][0]){
                queue.offer(jobs[idx++]);
            }
            
            if(queue.isEmpty()){
                currentTime = jobs[idx][0];
            }
            else{
                int[] job = queue.poll();
                currentTime += job[1];
                count++;
                total += currentTime - job[0];
                
            }
        }
        
        return total / jobs.length;
    }
}