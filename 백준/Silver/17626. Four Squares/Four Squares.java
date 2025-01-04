import java.io.*;

/**
 * 작은 문제들을 나열하다보면,  숫자 i는 자신의 제곱수(dp[j*j])들을 기준으로 제곱수를 뺀 나머지 값의 합을 구하면 된다.
 * 따라서 아래와 같은 점화식을 세울 수 있다.
 *  dp[n] = min(dp[n - k²] + 1)
 *
 */
public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받을 직사각형 가로 길이
        int N = Integer.parseInt(br.readLine());

        // dp배열 초기화
        dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;

        solve(N);

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
        br.close();
    }


    static void solve(int n) {
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }


    }
}
