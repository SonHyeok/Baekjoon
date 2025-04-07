import java.io.*;
import java.util.*;

/**
 * 연속 합은 dp[i] = dp[i - 1] + list[i]로 구할 수 있다.
 * 이것은 0 ~ i번째 까지의 연속 합을 의미한다.
 *
 * 여기서는 음수를 최대한 적게 더하는 것이 핵심인데, 이 전까지의 연속 합에서 현재 list[i]를 더한 값과 현재 list[i]를 비교해본다.
 * 이 전까지의 연속 합에서 list[i]를 더한 값이 list[i]보다 작다면, 당연히 dp[i] = list[i]로 대체하는 것이 이득이다.
 * 또한 현재 최댓값을 갱신하던 max의 값도 max 값과 dp[i]중에서 더 큰 값으로 갱신이 필요하다.
 *
 */
public class Main {

    static Integer[] dp;
    static int[] list;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        list = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 리스트 초기화
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        /*
         * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
         * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
         * max 또한 첫 번째 원소로 초기화 해준다.
         */

        dp[0] = list[0];
        max = list[0];

        recur(N - 1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static int recur(int index) {
        if (dp[index] == null) {
            dp[index] = Math.max(recur(index - 1) + list[index], list[index] );
        }

        max = Math.max(dp[index], max);

        return dp[index];
    }
}
