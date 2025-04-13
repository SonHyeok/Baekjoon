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

    static int[] list;
    static int[] op;
    static int N = 0;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 숫자의 갯수
        N = Integer.parseInt(br.readLine());

        // 수열 저장 및 연산자 갯수 저장할 배열 초기화
        list = new int[N];
        op = new int[4];

        // 수열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 배열 생성
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(list[0], 1);

        bw.write(MAX + "\n" + MIN);
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int num, int idx) {
        // 모든 수를 다 사용한 경우 최댓값, 최솟값 갱신
        if (idx == N) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        // 연산자 4가지에 대한 반복문
        for (int i = 0; i < 4; i++) {
            // 연산자 갯수가 1개 이상이면
            if (op[i] > 0) {

                // 연산자 갯수를 1개 줄임
                op[i]--;

                // 각 케이스에 해당하는 수에 대해 재귀적 실행
                switch(i) {
                    case 0: dfs(num + list[idx], idx + 1); break;
                    case 1: dfs(num - list[idx], idx + 1); break;
                    case 2: dfs(num * list[idx], idx + 1); break;
                    case 3: dfs(num / list[idx], idx + 1); break;
                }

                // 백트래킹을 위해 복구
                op[i]++;
            }
        }
    }
}
