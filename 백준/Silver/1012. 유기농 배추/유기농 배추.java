import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int width, height, K, count; // 배추밭 가로, 세로 크기와 배추 개수, 결과 카운트
    static boolean[][] visited; // 방문 여부 확인
    static int[][] list; // 배추밭 배열
    static int[] dx = {0, -1, 0, 1}; // x 방향 이동 (우, 상, 좌, 하)
    static int[] dy = {1, 0, -1, 0}; // y 방향 이동 (우, 상, 좌, 하)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());

            // 배추밭 가로, 세로 크기
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            // 배추 갯수
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[height][width];
            list = new int[height][width];

            // 입력받은 위치에 배추 셋팅
            initList(K);

            count = 0;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (list[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                if (!visited[ny][nx] && list[ny][nx] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static void initList(int K) throws IOException {
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[y][x] = 1;
        }
    }

}
