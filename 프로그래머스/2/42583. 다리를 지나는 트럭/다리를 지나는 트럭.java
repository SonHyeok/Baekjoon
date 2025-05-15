import java.util.*;

// 모든 트럭을 출발점에 세워서 가장 짧은 시간 안에 모두 다리를 건너도록 탐색
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();        
        int currentWeight = 0;
        int index = 0;
        
        while(index < truck_weights.length){
            answer++;
            
            // 트럭이 다리에서 빠져야 할 시간인 경우
            if(!queue.isEmpty() && queue.peek() + bridge_length <= answer){
                currentWeight -= truck_weights[index - queue.size()];
                queue.poll();
            }
            
            // 이번 차례의 트럭 무게와 현재 다리위의 트럭 무게 합산이 weight보다 작은 경우
            if(queue.size() < bridge_length && truck_weights[index] + currentWeight <= weight){
                queue.offer(answer);
                currentWeight += truck_weights[index];
                index++;
            }    

        }            
        return answer + bridge_length;
    }
}
