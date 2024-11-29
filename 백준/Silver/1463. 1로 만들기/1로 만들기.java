import java.io.*;


/**
 * 입력받는 자연수 N(1 <= N <= 10 ** 6)
 * N은 3으로 나누어 떨어지면 3으로 나누고,
 * 2로 나누어지면 2로 나눈다.
 * 위 두가지가 적용 되지 않으면, 적용될 때까지 N에서 1을 뺀다.
 *
 * 3으로 나누어 떨어질 경우 3으로 나누는 경우와 1을 뺀 후 3으로 나누는 경우 중 최솟값을 선택한다. 2인 경우에도 마찬가지이다.
 * 만약 공배수인 6으로 나누어 떨어질 경우는? 3으로 나눈 경우와, 2로 나눈 경우, 1을 뺀 경우를 모두 계산한 후 최솟 값을 정한다.
 */
public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 수 N
        int N = Integer.parseInt(br.readLine());

        // 메모이제이션을 위한 dp 배열
        dp = new Integer[N + 1];

        dp[0] = dp[1] = 0;

        bw.write(String.valueOf(recur(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * + 1씩 해주는 이유는 해당 연산을 재귀호출 하면서 카운트 1을 올리기 위함.
     * + 1을 하지 않으면 계속해서 0에서 안올라감
     * @param N
     * @return
     */
    static int recur(int N) {

        if (dp[N] == null) {

            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }

            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }

            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }

            else{
                dp[N] = recur(N - 1) + 1;
            }
        }

        return dp[N];
    }
}


