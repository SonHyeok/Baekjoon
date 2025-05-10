// 세로를 3부터 1씩 늘려가면서 체크
// 
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int total = brown + yellow;
        int width = 0;
        int height = 0;
        
        for(int i = total / 3; i > 0; i-- ){
            if(total % i == 0){
                width = i;
                height = total / i;
                
                int edge = (width + height) * 2 - 4;
                
                if(edge == brown) {
                    answer = new int[]{width,height};
                    break;
                }
            }
        }
        
        return answer;
    }
}

