import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[][] lists = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        List<Integer> goals = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < 3; i++){
            int count = 0;
            for(int j = 0; j < answers.length; j++){
                if(answers[j] == lists[i][j % lists[i].length]) count++;
            }
           
            goals.add(count); // 맞춘 갯수 배열에 추가
            max = Math.max(max,count); // 최대 맞춘 갯수 갱신
        }
        
        // 배열의 길이 설정 다시 필요!!
        List<Integer> sub = new ArrayList<>();
        
        for(int i = 0; i < goals.size(); i++){
            if(goals.get(i) == max) sub.add(i + 1);
        }
        
        answer = new int[sub.size()];
        for(int i = 0; i < sub.size(); i++){
            answer[i] = sub.get(i);
        }
        
        return answer;
    }
}