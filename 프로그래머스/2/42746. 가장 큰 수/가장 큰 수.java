import java.util.*;
import java.io.*;
/**
* 10으로나눈 나머지가 가장 큰 순서대로 정렬할 것
**/

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
        
        Arrays.sort(arr, (a,b) -> (b + a).compareTo(a + b));
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr){
            sb.append(s);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}