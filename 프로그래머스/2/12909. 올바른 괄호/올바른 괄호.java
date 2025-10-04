import java.util.*;
class Solution {
    boolean solution(String s) {        
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            
            else if(stack.isEmpty() && c == ')') {
                result = false;
                break;  
            }
            else stack.pop();
        }
        
        if(!stack.isEmpty()){
            result = false;
            return result;
        }
            
        return result;
        
    }
}