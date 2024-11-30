import java.io.*;


/**
 * 입력받는 자연수 N(N <= 300)
 * 계단은 1 or 2칸씩 올라갈 수 있음, 1칸 연속으로 3번은 불가능
 * 현 위치에서 한칸 올라간 결과와 두칸 올라간 결과중 더 큰 값을 반환
 * 재귀를 사용한 Top-Down 방식으로 해결
 */
public class Study {
    static Integer[] dp;
    static int[] floors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 자연수 N
        int N = Integer.parseInt(br.readLine());

        // 계단 배열 및 DP 배열 초기화
        floors = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            floors[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = floors[0];
        dp[1] = floors[1];

        // N 이 1이 입력될 경우 dp[2]는 초기화가 필요 없기 때문에 2 이상일 경우에만 초기화 하도록 예외처리를 해줄 필요가 있다.
        // 또한 N이 2인 경우에 dp[2]를 초기화 해주지 않으면 재귀 함수에서 find(-1) 호출이 발생해서 index out of 예외가 발생하기에 꼭 초기화 해준다.
        if (N >= 2) {
            dp[2] = floors[1] + floors[2];
        }

        bw.write(String.valueOf(find(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * find(N-1)을 호출하지 않고, floors[N-1]의 값을 더하는 이유는, N-1 번째까지의 총합과 N-3번째까지의 총합을 더하면 무조건 N-2번째 까지의 총합보다 클 수밖에 없다.
     * 따라서 N-3까지의 총합과 N-1번째 벽돌의 크기를 더한 값과, N-2까지의 총합을 비교하는게 맞다.
     */
    static int find(int N) {if (dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + floors[N - 1]) + floors[N];
        }

        return dp[N];
    }
}


