import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visit = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;

        dfs("",numbers,0);
        
        for(int num : set){
            if(num == 2) answer++;
            if(num % 2 != 0 && isPrime(num)) answer++;
        }
        return answer;
    }
    
    static void dfs(String s, String numbers, int depth){
        if(depth > numbers.length()) return;
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(s + numbers.charAt(i), numbers, depth + 1);
                visit[i] = false;
            }
        }
        
    }
    
    static boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 3; i <= Math.sqrt(num); i += 2){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}