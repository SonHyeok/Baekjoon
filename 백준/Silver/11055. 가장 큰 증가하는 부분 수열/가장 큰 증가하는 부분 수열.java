import java.io.*;
import java.util.*;

/**
 * 증가하는 부분 수열을 구하면서, 해당 수열의 합이 가장 높은 부분 수열을 구해야 함.
 * 다이나믹 프로그래밍 활용
 *
 * 반복문으로 각 숫자에 대해 현재까지의 합을 dp 테이블에 저장
 *
 * 시간 복잡도는 O(N^2) 시간이 소요될 것으로 측정(배열 list의 길이 만큼 N회 반복하기 때문)
 */
public class Main {

    static int[] dp = new int[1001];
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        Arrays.fill(dp, 10001);

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 재귀함수 호출
        for (int i = 0; i < N; i++) {
            recur(i);
        }

        int max = 0;

        // 최대값 선정
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static int recur(int N) {
        if (dp[N] == 10001) {
            dp[N] = list[N];

            for (int i = 0; i < N; i++) {
                if (list[i] < list[N]) {
                    dp[N] = Math.max(dp[N], recur(i) + list[N]);
                }
            }
        }
        return dp[N];
    }
}
