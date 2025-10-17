import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int sco : scoville){
            heap.offer(sco);
        }
        
        // 가장 작은 스코빌이 K보다 작고, heap의 크기가 1보다 큰 경우 반복
        while(heap.peek() < K && heap.size() > 1){
            int min1 = heap.poll();
            int min2 = heap.poll();
            
            heap.offer(min1 + (min2 * 2));
            answer++;
        }
        
        // 연산 종료 후 가장 작은 스코빌이 K보다 작을 경우 -1 반환
        if(heap.peek() < K) return -1;
        
        return answer;
    }

}