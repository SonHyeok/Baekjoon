import java.io.*;

/**
 * 직사각형의 가로 길이를 사용해서 가로 길이가 1인 타일과 2인 타일 2가지 종류로 어떻게 채우는지 계산한다
 * 가로 길이가 2보다 작지 않다면 -2가 가능하고, 2보다 작다면 -1이 가능한 경우로 나눈다.
 * 위 조건을 가지고 dp를 사용하여 풀이한다.
 * dp[k] = dp[k - 1] + dp[k - 2]
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

        dp[0] = 1;
        dp[1] = 1;

        int result = recur(N);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }


    static int recur(int n) {
        if (dp[n] == 0) {
            return dp[n] = (recur(n - 2) + recur(n - 1)) % 10007;
        }
        return dp[n];
    }
}

