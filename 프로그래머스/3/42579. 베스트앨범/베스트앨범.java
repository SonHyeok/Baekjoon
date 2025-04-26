/**
* Map 자료구조에 장르별 총 재생 횟수, 고유 번호를 저장
**/
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        Map<String, Map<Integer,Integer>> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            // 장르별 총 재생횟수 기록
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            // 장르별 고유 번호와 재생 횟수 기록
            if(!countMap.containsKey(genres[i])) countMap.put(genres[i], new HashMap<>());
            countMap.get(genres[i]).put(i,plays[i]);            
        }
        
        // 총 재생수 기준으로 장르 내림차순 정렬
        List<Map.Entry<String,Integer>> collect = map.entrySet()
            .stream()
            .sorted((n1,n2) -> {return n2.getValue().compareTo(n1.getValue());})
            .collect(Collectors.toList());
        
        // 장르별 재생횟수 기준으로 고유 번호 내림차순 정렬
        for(String key : countMap.keySet()){
            countMap.put(key, countMap.get(key).entrySet()
            .stream()
            .sorted((n1,n2) -> {return n2.getValue().compareTo(n1.getValue());})
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new)));
        }
        
        
        for(int i = 0; i < collect.size(); i++){
            
            String genre = collect.get(i).getKey();
            
            List<Integer> innerKeyList = new ArrayList<>(countMap.get(genre).keySet());

            for(int j = 0; j < Math.min(2, innerKeyList.size()); j++){
                result.add(innerKeyList.get(j));
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
            
    return answer;
    }
}


