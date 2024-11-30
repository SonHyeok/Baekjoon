import java.io.*;


/**
 * 입력받는 자연수 N(N <= 300)
 * 계단은 1 or 2칸씩 올라갈 수 있음, 1칸 연속으로 3번은 불가능
 * 현 위치에서 한칸 올라간 결과와 두칸 올라간 결과중 더 큰 값을 반환
 */
public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 자연수 N
        int N = Integer.parseInt(br.readLine());

        // 계단 배열 및 메모이제이션 배열
        int[] floors = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            floors[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        dp[0] = 0;
        dp[1] = floors[1];

        // N에 1이 입력될 수도 있기에 1보다 큰 경우에만 dp[2]가 초기화 되도록 예외 처리
        if (N >= 2) {
            dp[2] = floors[1] + floors[2];
        }

        for (int i = 3; i <= N; i++) {
            // 1,3칸 전의 값과, 2칸 전의 값중 최댓값을 찾아 현재 칸의 값과 덧셈 연산 진행후 메모이제이션
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + floors[i - 1]) + floors[i];
        }

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
        br.close();
    }
}


