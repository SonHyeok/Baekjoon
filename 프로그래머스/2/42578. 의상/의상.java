import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        int total = 1;
        
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for(int value : map.values()){
            total *= (value + 1);
        }
        
        return total - 1;
    }
}