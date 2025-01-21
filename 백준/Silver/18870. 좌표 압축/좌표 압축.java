import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 좌표 압축 문제로 유형에 대한 공부가 더 필요함
 * 입력과 출력을 봤을때 값에대한 우선순위를 매기는 것인듯
 * HashMap 또는 SET 사용
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 요소 갯수
        int count = Integer.parseInt(br.readLine());

        // 요소들 저장할 리스트
        int[] list = new int[count];

        st = new StringTokenizer(br.readLine());

        // 리스트 초기화
        for (int i = 0; i < count; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 우선순위 책정을 위한 리스트 정렬을 위해 복사
        int[] copyList = list.clone();

        // 정렬
        Arrays.sort(copyList);

        // 우선순위 저장할 Map
        Map<Integer, Integer> map = new HashMap<>();

        // 우선순위 랭크 변수
        int rank = 0;

        // 우선순위 책정 (key : value) => (리스트 요소, i값) 형식
        for (int i = 0; i < copyList.length; i++) {
            if (!map.containsKey(copyList[i])) {
                map.put(copyList[i], rank);
                rank++;
            }
        }

        // 요소들 별로 해당하는 우선순위 출력
        for (int i = 0; i < list.length; i++) {
            if (map.containsKey(list[i])) {
                bw.write(map.get(list[i]) + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
