import java.io.*;
import java.util.*;

/**
 * 투포인터 문제
 * 온도를 측정한 전체 날짜의 수 N과 합을 구하기 위한 연속적인 날짜의 수 K를 입력받음
 * start와 end를 사용해서 연속적인 k개의 날의 온도 합이 최대가 되는 값을 출력한다.
 *
 * 시간 복잡도는 100,000번 이하인 N만큼 반복하기에 O(1)의 시간으로 판단
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];

        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (end < N) {
            // K일보다 적은 경우 K일 수가 채워질 때까지 합산
            if (end - start < K) {
                sum += list[end++];
            }
            // K일보다 높거나 같은 경우 최대값 갱신 및 K일에 맞도록 누적합 감소
            else {
                max = Math.max(max, sum);
                sum -= list[start++];
            }
        }

        max = Math.max(max, sum);

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }

}
