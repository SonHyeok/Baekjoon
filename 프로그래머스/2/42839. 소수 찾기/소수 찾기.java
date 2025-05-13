import java.util.*;
class Solution {

    static boolean[] isUsed;
    public int solution(String numbers) {
        
        Set<Integer> set = new HashSet<>();
        isUsed = new boolean[numbers.length()];
        
        find(numbers, "", set);
        
        int answer = 0;
        
        for(Integer s : set){
            if(isPrime(s)) answer++;
        }
        
        
        
        return answer;
    }
    
    static void find(String numbers, String current, Set<Integer> set){
        if(numbers.length() == current.length()) return;
        
        for(int i = 0; i < numbers.length(); i++){
            if(!isUsed[i]) {
                isUsed[i] = true;
                System.out.println(current + String.valueOf(numbers.charAt(i)));
                set.add(Integer.parseInt(current + String.valueOf(numbers.charAt(i))));
                find(numbers, current + String.valueOf(numbers.charAt(i)), set);
                isUsed[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(num); i += 2){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}