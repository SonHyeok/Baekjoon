import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int n : scoville){
            queue.offer(n);
        } 
        
        //K보다 작은 숫자만큼 반복
        while(queue.peek() < K && queue.size() > 1){
            
            int newNum = queue.poll() + (queue.poll() * 2);
            queue.offer(newNum);
            answer++; // 스코빌 섞는 횟수 증가
        }
        
       int size = queue.size(); 
        
        // K이하인 지수가 있을 경우 -1 리턴
        for(Iterator<Integer> it = queue.iterator(); it.hasNext();){
            if(it.next() < K) return -1;
        }
        
        return answer;
    }
}