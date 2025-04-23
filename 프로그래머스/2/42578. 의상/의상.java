import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String,Integer> countMap = new HashMap<>(); // 의상 종류별 갯수 map
        
        for(String[] cloth : clothes){
            countMap.put(cloth[1], countMap.getOrDefault(cloth[1], 0) + 1);
        } 
        
        answer += countMap.values().stream().map(count -> count + 1).reduce(1, (arr,x) -> arr * x) - 1;
        
        
        return answer;
    }
}