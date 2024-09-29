import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     * 이항 계수 문제
     * N과 k의 이항 계수 (N\K) 구하기
     * N! / (N - K)! * K!
     * factorial 함수 필요
     */
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        bw.write(Integer.toString(factorial(n,k)));
        bw.flush();
        bw.close(); br.close();
    }

    public static int factorial(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return 1;
        }

        return dp[n][k] = factorial(n - 1, k - 1) + factorial(n - 1, k);
    }
}