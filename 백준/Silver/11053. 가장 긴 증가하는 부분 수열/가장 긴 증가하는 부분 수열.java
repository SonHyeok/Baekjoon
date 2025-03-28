import java.io.*;
import java.util.*;

/**
 * 가장 작은 수부터 시작해서 해당 숫자보다 큰 숫자가 나올때마다 길이를 갱신하고 현재 숫자도 갱신
 * 현재 수에서 만들 수 있는 가장 긴 길이의 수열로 항상 갱신 필요(dp)
 */
public class Main {
    static int[] dp = new int[1001];
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 10001);

        for (int i = 0; i < N; i++) {
            recur(i);
        }

        int max = dp[0];

        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static int recur(int N) {
        if (dp[N] == 10001) {
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (list[i] < list[N]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }

}
