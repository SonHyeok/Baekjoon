import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        
        Collections.sort(list, (a,b) -> (b + a).compareTo(a + b));
        
        for(String word : list) answer += word;
        
        if(answer.charAt(0) == '0') return "0";
        else return answer;
    }
}
