import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(64);

        while (true) {

            int total = 0;

            // 막대 길이 총합
            if (!list.isEmpty()) {
                for (int i : list) {
                    total += i;
                }
            }

            if (total == X) {
                bw.write(String.valueOf(list.size()));
                break;
            }

            // 길이의 합이 X보다 큰 경우
            if (total > X) {
                int midTotal = 0;

                // 가장 최근에 리스트에 추가된 막대 반으로 자르기
                int removed = list.remove(list.size() - 1);
                int half = removed / 2;

                // 자른 막대기의 반은 리스트에 추가
                list.add(half);

                // 중간 합 계산
                for (Integer i : list) {
                    midTotal += i;
                }

                // 중간 합이 X보다 작을 경우 자른 막대기의 나머지 한쪽 리스트에 추가
                if (midTotal < X) {
                    list.add(half);
                }
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }
}
