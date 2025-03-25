import java.io.*;
import java.util.*;

/**
 * 투포인터 문제
 * 숫자의 갯수 N과 목표 값 M을 입력받음
 * start부터 end까지의 합이 M과 같은 경우 count
 * 현재 누적 값이 M과 같은 경우에만 count를 함
 * 그 외에 M보다 클 경우에는 누적 값을 줄이고, 작은 경우에는 누적 값을 높임
 * 
 * 시간 복잡도는 최대 10,000인 N번 반복하기에 O(1) 시간 내로 종료
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // sum이 N보다 크거나 같은 경우에서
            if (sum >= M) {
                // N과 같은 경우에만 count를 하고, N보다 큰 경우에는 start값을 제거하고 한 칸 이동
                if (sum == M) {
                    count++;
                    sum -= list[start++];
                }else{
                    sum -= list[start++];
                }
            } 
            // end가 배열 크기와 같아진 경우 종료
            else if (end == N) {
                break;
            }
            // sum이 N보다 작은 경우
            else {
                sum += list[end];
                end++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}
