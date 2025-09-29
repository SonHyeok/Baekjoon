import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        char[] charList = s.toCharArray();
        
        for(char c : charList){
            if(c == '(') stack.push(c);
            else if(!stack.isEmpty() && c == ')') stack.pop();
            else{
                answer = false;
                break;
            }
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
        
    }
}