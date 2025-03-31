import java.io.*;
import java.util.StringTokenizer;

/**
 * 자릿수란 자연수의 맨 오른쪽부터 시작된다. 예를 들면 123456이라는 수가 있을 때 6의 자릿수의 자릿값은 1, 5는 2 --- 1의 자릿수의 자릿값은 6이다.
 * 또한 n번째 자릿수의 자릿값이 0인 경우 다음 자릿수의 자릿값은 1밖에 올 수 없고,
 * n번째 자릿수의 자릿값이 9인 경우 다음 자릿수의 자릿값은 8밖에 올 수 없다.
 * 해당 경우를 고려하여 풀이한다.
 *
 * 점화식은 n번째 자릿수의 자릿값이 0인 경우, dp[i][j] = dp[i - 1][1],
 * n번째 자릿수의 자릿값이 9인 경우, dp[i][j] = dp[i - 1][8],
 * 이외의 경우는 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] 이다.
 *
 */
public class Main {

    // dp가 2차원 배열인 이유는 dp[i][j]일 때 i는 계단의 길이, j는 가장 맨 앞의 자릿수가 j일 때를 의미한다.
    static Long[][] dp;

    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            // 길이가 1인 경우 모든 자릿수의 자릿값에 대해서 옆에 올 수 있는 수가 없기에 1로 설정
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i < 10; i++) {
            result += recur(N, i);
        }

        bw.write(String.valueOf(result % MOD));
        bw.flush();
        bw.close();
        br.close();
    }

    static long recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }else{
                dp[digit][val] = recur(digit - 1, val + 1) + recur(digit - 1, val - 1);
            }
        }

        return dp[digit][val] % MOD;
    }

}
