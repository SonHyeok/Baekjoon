import java.io.*;

/**
 * 규칙성이 존재함. 현재 위치가 n라고 하면 n - 2, n - 3의 위치 값을 더한 값이 n 위치의 값이 나옴
 * DP 유형이므로 재귀를 통한 메모이 제이션 필요
 * 테스트 케이스가 1부터 시작하기에 인덱스도 1부터 시작시킴
 * 테스트 케이스가 4 이하일 경우 1을 반환하고, 4 이상일 경우는 점화식인 dp[n] = dp[n - 2] + dp[n - 3]을 적용
 */
public class Main {

    static Long[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        // dp 배열 초기화
        dp = new Long[101];

        dp[0] = 0L;
        dp[1] = dp[2] = dp[3] = 1L;

        // 재귀 함수 호출해서 삼각형 변의 길이 출력
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(find(N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Long find(int n) {
        if (dp[n] == null) {
            // n이 4 이상인 경우 재귀 호출을 통해 메모이 제이션 후 반환
            return dp[n] = find(n - 2) + find(n - 3);
        }

        return dp[n];
    }


}

