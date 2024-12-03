import java.io.*;


/**
 * 입력받는 자연수 N (1 <= N <= 10 ^ 6)
 * N이 3으로 나누어지면 3으로 나누고, 2로 나누어지면 2로 나누고, 둘 다 나누어지지 않으면 1을 뺀다.
 * N을 1로 만들기 위해 가장 최소한의 방법으로 연산하는 횟수를 구할 것.
 * EX) 10: 10 -> 5 -> 4 -> 2 -> 1 이렇게 하면 4번 연산
 *      10: 10 -> 9 -> 3 -> 1 이렇게 3번 가능
 */
public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 자연수 N
        int N = Integer.parseInt(br.readLine());

        // 입력받은 크기의 dp 배열 생성
        dp = new Integer[N + 1];

        // 0과 1은 연산을 진행하지 않기에 0으로 초기화
        dp[0] = dp[1] = 0;

        bw.write(String.valueOf(find(N)));
        bw.flush();

        bw.close();
        br.close();
    }

    /**
     * 6으로 나누어질 경우 3이나 2로 나눈 수 중에서 연산 횟수 결과가 작은 수로 연산 진행
     *
     * @param N
     * @return
     */
    static int find(int N) {
        if (dp[N] == null) {
            if (N % 3 == 0 && N % 2 == 0) {
                dp[N] = Math.min(find(N / 3), find(N / 2)) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(find(N - 1), find(N / 3)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(find(N - 1), find(N / 2)) + 1;
            }else{
                dp[N] = find(N - 1) + 1;
            }
        }

        return dp[N];
    }
}


