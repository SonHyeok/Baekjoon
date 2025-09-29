// 큐에 들어온 숫자가, 가장 마지막에 들어온 큐의 숫자보다 작을 경우 배포 불가능.
// 큐에 들어오는 숫자, 가장 마지막에 들어온 큐의 숫자보다 클 경우 배포 가능.
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int curProgress = 100 - progresses[i];
            int date = curProgress % speeds[i] == 0 ? curProgress / speeds[i] 
                : curProgress / speeds[i] + 1;
            
            if(!queue.isEmpty() && queue.peek() < date){
                list.add(queue.size());
                queue.clear();
            }
        
            queue.offer(date);
        }
        list.add(queue.size());
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
            
        return result;
    }
}