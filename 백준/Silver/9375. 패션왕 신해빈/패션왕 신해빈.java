import java.io.*;
import java.util.*;


/**
 * 자료구조 문제
 * Map<String, Integer> 자료구조를 사용해서 의상의 카테고리에 의상 갯수를 추가함
 * 옷을 아무것도 입지 않는 상황도 포함해서 고려해야 한다. => 각 카테고리 의상 갯수에 + 1
 * 각 카테고리의 의상 갯수에 + 1을 하여 모두 곱한 후에 아무것도 입지 않은 경우인 경우 1개를 뺀다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력받는 자연수 T
        int T = Integer.parseInt(br.readLine());

        // 의상 저장할 Map
        Map<String, Integer> map;
        
        for (int i = 0; i < T; i++) {
            // 매번 map 초기화 필요
            map = new HashMap<>();

            // 의상 갯수
            int N = Integer.parseInt(br.readLine());

            // map에 의상 카테고리별 갯수 추가
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                // 의상 이름은 제거
                st.nextToken();

                // 의상 카테고리
                String category = st.nextToken();

                // 의상 카테고리가 존재하면 + 1, 아니면 1값으로 세팅해서 추가
                if (map.containsKey(category)) {
                    map.put(category, map.get(category) + 1);
                }else{
                    map.put(category, 1);
                }
            }

            int count = 1;
            
            // 알몸인 경우를 추가해서 모든 경우의 수 곱셈 연산
            for (String key : map.keySet()) {
                count *= (map.get(key) + 1);
            }

            // 알몸인 경우 제거
            bw.write((count - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

