// SJF 스케줄러 사용 문제

// 작업의 소요 시간이 더 짧고, 먼저 요청이 들어온 순서대로 정렬
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        // 요청 시간 기준 오름차순 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 작업 시간 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int currentTime = 0; // 현재 시간
        int idx = 0; // 작업 인덱스
        int count = 0; // 종료한 작업 갯수
        int total = 0; // 총 반환 시간
        
        // 종료한 작업 갯수가 jobs 길이과 같아질 때 까지 반복
        while(count < jobs.length){
            // 이전 작업 진행중 진입한 작업 대기 큐에 추가
            while(idx < jobs.length && currentTime >= jobs[idx][0]){
                queue.offer(jobs[idx++]);
            }
            
            // 큐가 비어있는 경우 다음 작업 시작 시점으로 현재 시간 이동
            if(queue.isEmpty()){
                currentTime = jobs[idx][0];
            }
            // 큐가 비어있지 않는 경우
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