import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>(); // 장르별 총 재생 수
        Map<String, Map<Integer, Integer>> countMap = new HashMap<>(); // 장르별 (고유번호, 재생수)

        //  map, countMap 만들기
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            if (!countMap.containsKey(genres[i])) {
                countMap.put(genres[i], new HashMap<>());
            }
            countMap.get(genres[i]).put(i, plays[i]);
        }

        // 장르별 총 재생수 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> collect = map.entrySet()
            .stream()
            .sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue()))
            .collect(Collectors.toList());

        // 장르별 고유 번호(노래) 재생수 기준 내림차순 정렬
        for (String key : countMap.keySet()) {
            countMap.put(key, countMap.get(key).entrySet()
                .stream()
                .sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                )));
        }

        // 결과 리스트에 고유번호 저장
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < collect.size(); i++) {
            String genre = collect.get(i).getKey();

            List<Integer> innerKeyList = new ArrayList<>(countMap.get(genre).keySet());

            // 최대 2곡까지 추가
            for (int j = 0; j < Math.min(2, innerKeyList.size()); j++) {
                result.add(innerKeyList.get(j));
            }
        }

        // List를 int[]로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

// 아래는 클래스를 활용한 풀이
// import java.util.*;
// import java.util.stream.Collectors;

// class Solution {
//     public int[] solution(String[] genres, int[] plays) {
        
//         int[] answer = {};
//         List<Integer> result = new ArrayList<>();
        
//         Map<String, List<Song>> songMap = new HashMap<>();
//         Map<String, Integer> playMap = new HashMap<>();

//         // 값 세팅
//         for (int i = 0; i < genres.length; i++) {
//             songMap.putIfAbsent(genres[i], new ArrayList<>());

//             songMap.get(genres[i]).add(new Song(i, plays[i]));
//             playMap.put(genres[i], playMap.getOrDefault(genres[i], 0) + plays[i]);
//         }

//         // 장르를 총 재생 수 기준으로 내림차순 정렬
//         List<String> sortedGenres = new ArrayList<>(playMap.keySet());
//         sortedGenres.sort((n1,n2) -> playMap.get(n2).compareTo(playMap.get(n1)));

//         //각 장르별로 노래를 play 수, index 기준 정렬 후 2개씩 선택
//         for (String key : sortedGenres) {
//             List<Song> genre = songMap.get(key);
//             genre.sort((n1,n2) -> {
//                 if(n1.play != n2.play){
//                     return n2.play - n1.play;
//                 }else{
//                     return n1.index - n2.index;
//                 }
//             });
            
//             // 최대 2곡 선택
//             for (int i = 0; i < Math.min(2, genre.size()); i++) {
//                 result.add(genre.get(i).index);
//             }
//         }

//         answer = new int[result.size()];

//         // List -> int[] 변환
//         for (int i = 0; i < result.size(); i++) {
//             answer[i] = result.get(i);
//         }
        
//         return answer;
//     }
// }


// class Song{
//     int index;
//     int play;

//     Song(int index, int play){
//         this.index = index;
//         this.play = play;
//     }
// }
