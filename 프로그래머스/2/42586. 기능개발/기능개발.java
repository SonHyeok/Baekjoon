// 큐에 들어온 숫자가, 가장 마지막에 들어온 큐의 숫자보다 작을 경우 배포 불가능.
// 큐에 들어오는 숫자, 가장 마지막에 들어온 큐의 숫자보다 클 경우 배포 가능.
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            // 작업에 소요되는 일수 계산
            int days = (100 - progresses[i]) % speeds[i] == 0 ? 
                (100 - progresses[i]) / speeds[i] : ((100 - progresses[i]) / speeds[i]) + 1;
            
            // 작업에 소요되는 일 수가 현재 큐에 저장된 가장 긴 작업보다 오래 걸리는 경우
            if(!queue.isEmpty() && queue.peek() < days){
                list.add(queue.size()); // 배포 후 큐 초기화
                queue.clear();
            }
            
            // 작업 일 수 큐에 추가
            queue.offer(days);
        }
        
        list.add(queue.size()); // 마지막 배포 작업 갯수 추가
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
   
    
    }
}