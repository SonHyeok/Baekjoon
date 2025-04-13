import java.io.*;
import java.util.StringTokenizer;

/**
 * 연산자는 [ +, -, *, /] 순서로 존재
 * 연산자에 대해 체크할때는 연산자의 인덱스 확인 후 0이 아닌 경우 해당 연산자를 사용하고, -1 연산을 해서 연산자의 갯수를 줄여준다.
 *
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] list;   // 수열 저장 배열
    static int[] op;     // 각 연산자(+, -, *, /)별 남은 개수를 저장하는 배열 (인덱스 순서대로 저장)
    static int N = 0;    // 수의 개수
    static int MAX = Integer.MIN_VALUE; // 가능한 결과 값 중 최댓값 (초깃값은 가장 작은 정수)
    static int MIN = Integer.MAX_VALUE; // 가능한 결과 값 중 최솟값 (초깃값은 가장 큰 정수)

    public static void main(String[] args) throws IOException {

        // 수의 개수를 입력받음
        N = Integer.parseInt(br.readLine());

        // 수열과 연산자 개수를 저장할 배열 초기화
        list = new int[N];
        op = new int[4];

        // 수열 입력: 각 토큰(숫자)을 배열 list에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력: 토큰 순서대로 +, -, *, /의 개수를 배열 op에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 숫자를 초기값으로 하여, 인덱스 1부터 DFS 탐색 시작
        dfs(list[0], 1);

        // 탐색이 완료된 후, 구한 최댓값과 최솟값을 출력
        bw.write(MAX + "\n" + MIN);
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int num, int idx) {
        // 종료 조건: 수열의 모든 숫자를 다 사용한 경우
        if (idx == N) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        // 4개의 연산자에 대해 반복 처리
        for (int i = 0; i < 4; i++) {
            // 해당 연산자가 남아있는 경우만 진행
            if (op[i] > 0) {
                // 연산자 개수를 1 감소시킨 후
                op[i]--;

                // i 값에 따라 각 연산 케이스에 따라 재귀 호출
                switch(i) {
                    case 0: dfs(num + list[idx], idx + 1); break;
                    case 1: dfs(num - list[idx], idx + 1); break;
                    case 2: dfs(num * list[idx], idx + 1); break;
                    case 3: dfs(num / list[idx], idx + 1); break;
                }

                // 재귀 호출 후, 다른 경우의 수 탐색을 위해 연산자 개수를 다시 복구 (백트래킹)
                op[i]++;
            }
        }
    }
}
