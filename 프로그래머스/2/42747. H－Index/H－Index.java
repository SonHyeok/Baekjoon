import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        int answer = Integer.MIN_VALUE;
        int len = citations.length; // 논문 총 갯수       
        
        Arrays.sort(citations);
        
        for(int i = 0; i < len; i++){
            // 일정 횟수 이상 인용된 논문의 갯수가 인용 횟수보다 크거나 같은 경우
            if(citations[i] >= len - i){ // 여기서 len - i는 일정 횟수 이상 인용된 논문의 갯수를 의미
                answer = len - i; // 해당 논문의 갯수를 최댓값으로 설정 후 종료
                break;
            }
        }
        
        if(answer == Integer.MIN_VALUE) return 0;
        
        return answer;
    }
}