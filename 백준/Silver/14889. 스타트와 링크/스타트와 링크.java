import java.io.*;
import java.util.StringTokenizer;

/**
 * 인원을 배치할 2차원 배열, 배치된 인원의 여부를 저장할 1차원 boolean 배열 생성
 * 재귀를 통해 팀원을 추가하면서 팀원이 전체 인원의 반이 되면 두 그룹의 차이를 계산 후 최솟값 갱신
 * 최솟값이 0이라면 모든 함수를 종료시킴.(이미 0보다 작을 수는 없기에)
 * 그러나 계산한 최솟값이 현재 최소값보다 크다면 백트래킹
 *
 *
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int[][] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        list = new int[N][N];
        visited = new boolean[N];

        // 배열 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(MIN));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, int count) {
        // 선출된 팀원의 수가 전체 인원의 반일 경우 최소값 갱신
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            // 선출되지 않은 번호의 인원일 경우
            if (!visited[i]) {
                visited[i] = true; // 선출로 변경
                dfs(i + 1, count + 1); // 다음 팀원 선출을 위한 재귀함수 호출
                visited[i] = false; // 비선출로 변경
            }
        }
    }

    static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i 와 j 모두 true == 팀 start인 경우
                if (visited[i] && visited[j]) {
                    teamStart += (list[i][j] + list[j][i]);
                }
                // i와 j 모두 false == 팀 link인 경우
                else if (!visited[i] && !visited[j]) {
                    teamLink += (list[i][j] + list[j][i]);
                }
            }
        }
        // 그룹의 차 계산
        int val = Math.abs(teamStart - teamLink);

        // 차가 0인 경우 최소값을 0으로 갱신 이후 함수 종료
        if (val == 0) {
            MIN = 0;
            return;
        }

        // 차가 0이 아닌경우 최소값 갱신
        MIN = Math.min(MIN, val);
    }


}
