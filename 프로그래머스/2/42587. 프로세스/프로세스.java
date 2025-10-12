import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{priorities[i],i});
            maxHeap.offer(priorities[i]);
        }
        
        while(!queue.isEmpty()){
            int idx = queue.peek()[1];
            int value = queue.peek()[0];
        
            // 현재 큐에서 뽑은 값이 최대값과 같은 경우
            if(value == maxHeap.peek()){
                // 최대값이며 찾던 위치인 경우
                if(idx == location){
                    count++;
                    break;
                }
                
                queue.poll();
                maxHeap.poll();
                count++;
            }else{
                queue.offer(queue.poll());            
            }
        }
        
        return count;
    }
}