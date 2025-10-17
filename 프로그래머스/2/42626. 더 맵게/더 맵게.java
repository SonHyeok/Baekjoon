import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int sco : scoville){
            heap.offer(sco);
        }
        
        while(heap.peek() < K && heap.size() > 1){
            int min1 = heap.poll();
            int min2 = heap.poll();
            
            heap.offer(min1 + (min2 * 2));
            answer++;
        }
        
        if(heap.peek() < K) return -1;
        
        return answer;
    }

}