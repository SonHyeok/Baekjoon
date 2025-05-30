import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        // 다른 번호에서 접두사의 위치가 0번째 인덱스인 경우 false
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].indexOf(phone_book[i]) == 0){
                answer = false;
                break;
            } 
        }
        return answer;
    }
}