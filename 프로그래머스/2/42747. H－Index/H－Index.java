import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        
        for(int i = 0; i < citations.length; i++){
            int smaller = Math.min(citations[i], citations.length - i);
            hIndex = Math.max(hIndex, smaller);
            
        }
        
        return hIndex;
    }
}


// [2,2,3,3,5]