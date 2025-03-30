import java.io.*;
import java.util.*;

/**
 * 최대 2번까지 연속으로 포도주를 마실 수 있으며, 주어진 포도주 잔들 중 가장 많은 포도주를 마실 수 있는 포도주의 조합을 찾아야 함
 * 매 포도주마다 2번 이하로 마셨는지 체크하고, 다음 포도주를 마셨을때와 안마시고 그다음 포도주를 마셨을 때 어떤 총량이 더 많은지 찾기
 * 점화식은 dp[n] = Math.max(dp[n + 1], dp[n + 2])
 */
public class Main {

    static Integer[] dp;
    static int[] list;
    // 현재 마신 횟수 저장하는 변수
    static int curCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        dp = new Integer[N + 1];

        // 배열 생성
        for (int i = 1; i < N + 1; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = list[1];

        /*
         *  (N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
         */
        if (N > 1) {
            dp[2] = list[1] + list[2];
        }

        bw.write(String.valueOf(recur(N)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int recur(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + list[N - 1]) + list[N], recur(N - 1));
        }
        return dp[N];
    }
}
