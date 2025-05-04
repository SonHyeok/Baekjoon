import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxHeight = Integer.MIN_VALUE;
        int maxWidth = Integer.MIN_VALUE;
        
        sizes = Arrays.stream(sizes).map(row -> {
            Arrays.sort(row);
            return row;})
            .toArray(int[][]::new);
        
        for(int[] list : sizes){
            maxWidth = Math.max(maxWidth, list[0]);
            maxHeight = Math.max(maxHeight, list[1]);
        }
        
        answer = maxHeight * maxWidth;
        
        return answer;
    }
}