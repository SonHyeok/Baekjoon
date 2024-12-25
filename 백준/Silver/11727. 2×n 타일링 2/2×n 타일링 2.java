import java.io.*;

/**
 * 직사각형의 가로 길이를 사용해서 가로 길이가 1인 타일과 2인 타일, 가로 세로 모두 길이가 2인 타일로 총 3가지 종류로 어떻게 채우는지 계산한다
 * 가로 길이가 2보다 작지 않다면 -2가 가능하고, 2보다 작다면 -1이 가능한 경우로 나눈다.
 * 이전에 경우에서 가로 세로 모두 길이가 2인 타일이 추가되었으나, 가로 길이가 2, 세로 길이가 1인 타일의 경우에 2배를 해주고 가로 1 세로 2인 타일로 채우는 경우의 수를 더해주면 된다
 * 위 조건을 가지고 dp를 사용하여 풀이한다.
 * dp[k] = dp[k - 1] + (dp[k - 2] * 2)
 */
public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받을 직사각형 가로 길이
        int N = Integer.parseInt(br.readLine());

        // dp배열 초기화
        dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);

    }



}
