import java.io.*;
import java.util.*;

/**
 * 먼저 dp 배열은 2차원 배열로 생성한다.
 * 그 이유는 먼저 dp[i][j]일 때, i는 계단의 갯수를 말하며 j는 해당 자릿수의 값이 N임을 의미한다.
 * 따라서 dp[i][j]는 i개의 계단이 있을 때, j번째 자릿수의 값이 N일 경우 인접한 자리에 올 수 있는 숫자의 경우의 수를 의미한다.
 *
 * 만일 N번째 자리의 자릿값이 0인 경우 인접한 자리의 자릿값은 1밖에 올 수 없고,
 * 자릿값이 9인 경우 인접한 자리의 자릿값은 8밖에 올 수 없다.
 * 그 이외의 값은 N - 1 또는 N + 1의 값이 올 수 있다.
 * 따라서 점화식은 아래와 같이 세울 수 있다.
 * 자릿값이 0인 경우 dp[i][j] = dp[i - 1][1]
 * 자릿값이 9인 경우 dp[i][j] = dp[i - 1][8]
 * 자릿값이 그 외에 숫자인 경우 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
 */
public class Main {

    static Long[][] dp;
    static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // col에 해당하는 자리가 10인 이유는 0~9까지 값이 존재할 수 있기 때문
        dp = new Long[N + 1][10];

        // 계단이 1개인 경우 모든 인접한 자리에 숫자가 올 수 없고, 한 자리만 존재하기에 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i < 10; i++) {
            result += recur(N,i);
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
                // 여기서 digit - 1을 호출하는 이유는 현재 계단 갯수가 3개이고, 첫번째 자릿수가 0인 경우?
                // 그 다음 자릿수는 1인게 분명하며, 계단 수가 2일 때 첫번째 자릿수가 1인 경우의 수를 구하면 그게 곧 dp[3][0]의 값이 되기 때문이다.
                dp[digit][val] = recur(digit - 1, 1);
            }
            else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }
            else{
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;
    }

}
