import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS를 사용하여 목표지점을 시작 지점으로 설정하고 탐색을 진행
 * 목표 지점을 시작 지점으로 설정후, 다른 지점까지 걸리는 횟수를 측정하는 방식으로 변형해서 풀이
 * BFS는 최단 거리가 보장되기 때문에 사용
 *
 */
public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static boolean[][] visited;
    static int row;
    static int col;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new int[row][col];
        visited = new boolean[row][col];

        Integer[] start = new Integer[2];

        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                // 목표 지점 좌표 생성
                if (input[j].equals("2")) {
                    start[0] = i;
                    start[1] = j;
                }
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        BFS(start);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(Integer[] start) {

        // 큐 생성후 시작점 추가
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(start);

        // 목표 지점 0으로 변경
        graph[start[0]][start[1]] = 0;
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            // 현재 지점부터 상,하,좌,우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 상,하,좌,우 탐색 불가능한 조건이 아니면서
                if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                    // 다음 지점이 1이고, 방문 기록이 없을 경우
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        // 이전 지점에서 + 1한 값을 현재 지점 값으로 변경
                        graph[nx][ny] = graph[cx][cy] + 1;
                        // 방문 기록
                        visited[nx][ny] = true;

                        // 다음 이동점 추가
                        queue.offer(new Integer[]{nx, ny});
                    }
                }
            }
        }
    }
}
