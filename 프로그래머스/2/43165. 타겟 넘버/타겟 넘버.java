// +와 -하는 경우를 모두 계산하며 dfs 진행
// 진행 완료 후 target과 결과가 같다면 answer++ 
import java.util.*;


class Solution {

    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0,0, numbers, target);
        
        answer = count; 
        
        return answer;
    }
    static void dfs(int current, int idx, int[] numbers, int target){
        // 합인 N이 target과 같고 끝까지 연산이 끝난 경우
        
        if(idx == numbers.length){
            if(current == target){
                count++; 
            }
            return;
        }

            dfs(current + numbers[idx], idx + 1, numbers, target);
            dfs(current - numbers[idx], idx + 1, numbers, target);
        
    }
}