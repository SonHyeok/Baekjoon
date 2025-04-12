import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] tomato;
    static Queue<Integer[]> queue = new LinkedList<>();

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int N,M;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 M, 세로 N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                tomato[i][j] = num;

                if (num == 1) {
                    queue.offer(new Integer[]{i, j});
                }
            }
        }

        // 시작날을 제외한 최소 일수 반환
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();


    }


    static int bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            // 현재 좌표
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                // 다음 이동할 좌표
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        queue.offer(new Integer[]{nx, ny});
                        // 익는 날짜 체크를 위해 현재보다 1 높은 수로 변경
                        tomato[nx][ny] = tomato[cx][cy] + 1;
                    }
                }
            }
        }

        // 탐색 진행 후 안익은 토마토가 남아있을 경우 -1 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
                // 안익은 토마토가 없을 경우 익는데 걸리는 최소 일수 체크
                count = Math.max(count, tomato[i][j]);
            }
        }

        // 모두 익은 토마토만 있었던 경우 0 반환
        if (count == 1) {
            return 0;
        }else{
            return count - 1;
        }
    }

}
