import java.util.*;

// 모든 트럭을 출발점에 세워서 가장 짧은 시간 안에 모두 다리를 건너도록 탐색


class Solution {
    class Truck{
        int weight;
        int move;
        
        public Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving(){
            move++;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        
        for(int i : truck_weights){
            waitQ.offer(new Truck(i));
        }
        
        int curWeight = 0;
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()){
            answer++;
            
            if(moveQ.isEmpty()){
                Truck t = waitQ.poll();
                moveQ.offer(t);
                curWeight += t.weight;
                continue;
            }
            
            for(Truck t : moveQ){
                t.moving();
            }
            
            if(moveQ.peek().move > bridge_length){
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }
            
            if(!waitQ.isEmpty() && waitQ.peek().weight + curWeight <= weight){
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
            
        }
        
        return answer;
    }
}
