import java.io.*;
import java.util.*;

/**
 * 목표 지점까지의 최단 거리를 구해야 하기에 BFS를 사용하여 풀이
 *  각각의 수들이 붙어서 입력으로 주어지기에 CHAR 배열을 사용하여 풀이
 * 상,하,좌,우를 탐색하면서 숫자를 1씩 늘려감
 * 최종 목적지에 도착한 경우 이전에 통계낸 숫자와 현재 통계낸 숫자를 비교하여 더 작은 값을 선정
 * 
 * 시간 복잡도
 * 입력 수 2개가 0 ~ 100 사이임
 * 최대 100 X 100의 배열이 만들어진다.
 * 이후 각 점마다 이동하면서 상,하,좌,우를 검사하기에 최대 100 X 100 X 4번 연산 실행
 * 따라서 시간 복잡도는 O(1) 시간 내로 해결될 것으로 예상함
 */
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 배열 초기화
        graph = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            // String 타입 배열로 형 변환
            String[] array = br.readLine().split("");

            // graph 생성
            for (int j = 0; j < array.length; j++) {
                graph[i][j] = Integer.parseInt(array[j]);
            }
        }

        bw.write(String.valueOf(bfs(row,col)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int row, int col) {
        Queue<Integer[]> queue = new LinkedList<>();

        visited[0][0] = true;

        // x, y, 이동 횟수 배열
        queue.offer(new Integer[]{0, 0, 1});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            // 현재 X, Y, 이동 횟수
            int cx = now[0];
            int cy = now[1];
            int cnt = now[2];

            // 도착점 도착시 이동 횟수 반환
            if (now[0] == col - 1 && now[1] == row - 1) {
                return cnt;
            }

            // 상 하 좌 우 탐색
            for (int i = 0; i < 4; i++) {

                // 다음 이동 좌표
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= col - 1  && ny <= row - 1) {
                    if (graph[ny][nx] == 1 && !visited[ny][nx]) {

                        // 방문 기록
                        visited[ny][nx] = true;

                        // queue에 다음 이동 점 추가
                        queue.offer(new Integer[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
}

