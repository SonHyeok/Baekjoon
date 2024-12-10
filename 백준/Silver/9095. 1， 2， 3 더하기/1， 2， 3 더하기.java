import java.io.*;


/**
 * 입력받는 자연수 N(0 < N < 11)
 * N에 대해 1,2,3의 합으로 나타내는 방법의 수 계산
 * 점화식을 구해서 풀기
 */
public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 자연수 N
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            bw.write(dp[now] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

// 1 = {1} => 1개,
// 2 = {1 + 1, 2} => 2개,
// 3 = {1 + 1 + 1, 1 + 2, 2 + 1, 3} => 4개

// 4 = {1 + 1 + 1 + 1, 1 + 2 + 1, 3 + 1, 2 + 1 + 1, <= 3을 구하는 경우의 수에 각각 + 1
//      1 + 1 + 2, 2 + 2, <= 2를 구하는 경우의 수에 각각 + 2
//      1 + 3, } <= 1을 구하는 경우의 수에 각각 + 3

//  1을 구하는 경우의 수에 3을 더하면 4가 나오고
//  2를 구하는 경우의 수에 각각 2를 더하면 4가 나오고,
//  3을 구하는 경우의 수에 각각 1을 더하면 4가 나온다.
//  결론은 1, 2, 3을 구하는 경우의 수를 모두 더하면 4를 구하는 경우의 수가 나온다
// 점화식 dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]