import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작점 추가
        queue.offer(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            int n = queue.getLast();
            
            // 연속된 숫자가 아니라면 큐에 추가
            if(n != arr[i]) queue.offer(arr[i]); 
        }
        
        answer = new int[queue.size()];
        
        for(int i = 0; i < queue.size(); i++) answer[i] = queue.poll();
    
        return answer;
    }
    
}