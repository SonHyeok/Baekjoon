import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer[]> queue = new LinkedList<>();
        
        int max = findMax(priorities);
        
        // 가장 높은 우선순위 탐색 및 큐에 추가
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Integer[]{i, priorities[i]});
        }
        
        while(true){
            Integer[] cur = queue.peek();
            int index = cur[0];
            int priority = cur[1];
            
            // 현재 우선순위가 가장 빠른경우
            if(priority == max){
                queue.poll(); // 제거
                answer++; // 작업 횟수 추가

                if(index == location){ // 우선순위가 가장 빠르고 찾는 위치의 작업인 경우
                    break;
                }   
                
                priorities[index] = -1; // 가장 큰 우선순위의 작업 제거 후 우선순위를 -1로 변경
                max = findMax(priorities); // 새로운 큰 우선순위 선별
            }
            // 우선순위가 낮으면 뒤로 넘김
            else if(priority < max) {
                queue.offer(queue.poll());
            }
        }
        
        return answer;
    }
    
    static int findMax(int[] priorities){
        int newMax = 0;
        
        for(int p : priorities){
            if(p == -1) continue;
            newMax = Math.max(newMax, p);
        }
        System.out.println("newMax : " + newMax);
        return newMax;
    }
    
}