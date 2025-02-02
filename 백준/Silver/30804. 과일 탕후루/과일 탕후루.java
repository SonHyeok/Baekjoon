import java.io.*;
import java.util.*;


/**
 * 1~9까지의 번호가 붙어있는 과일 존재
 * 앞,뒤로 과일들을 빼면서 과일의 종류를 체크
 * 2가지의 과일로만 탕후루를 만들면서 과일의 갯수가 최대인 경우를 찾아야 함
 * 투 포인터 알고리즘을 사용하여 풀이
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int result = 0;

        for (int end = 0; end < count; end++) {
            // map에 과일 추가
            map.put(list.get(end), map.getOrDefault(list.get(end), 0) + 1);

            // 과일 종류가 2개보다 많은 경우
            while (map.size() > 2) {
                // map에서 과일 차감
                map.put(list.get(start), map.getOrDefault(list.get(start), 0) - 1);

                // 과일이 0개인 경우 제거
                if (map.get(list.get(start)) == 0) {
                    map.remove(list.get(start));
                }

                start++;
            }
            result = Math.max(result, end - start + 1);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

