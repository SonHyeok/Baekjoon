import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visit = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;

        dfs("",numbers);
        
        for(int num : set){
            if(num == 2) answer++;
            if(num % 2 != 0 && isPrime(num)) answer++;
        }
        return answer;
    }
    
    static void dfs(String s, String numbers){
        int n = numbers.length();
        
        if(!s.equals("")) set.add(Integer.parseInt(s));
        
        for(int i = 0; i < numbers.length(); i++){
            dfs(s + numbers.charAt(i), numbers.substring(0,i) + numbers.substring(i + 1, n));
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