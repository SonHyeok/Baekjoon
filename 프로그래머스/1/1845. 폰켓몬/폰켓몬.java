import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n : nums) map.put(n, map.getOrDefault(n,0) + 1);

        int half = nums.length / 2; // 전체 포켓몬 수의 반
        int size = map.keySet().size(); // 포켓몬 종류 수

        if(half >= size) answer = size;
        else answer = half;
        
        
        return answer;
    }
}