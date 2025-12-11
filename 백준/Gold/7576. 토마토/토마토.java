import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[]{0,0,-1,1};
    static int[] dx = new int[]{-1,1,0,0};

    static int M,N;
    static int[][] graph;
    static boolean[][] visited;
    static int count = -1;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                int n = Integer.parseInt(st.nextToken());
                graph[x][y] = n;

                // 토마토가 있는 좌표 저장
                if (n == 1) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        bfs();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (graph[x][y] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (graph[nx][ny] == -1) {
                        continue;
                    }

                    if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        graph[nx][ny] = 1;
                        visited[nx][ny] = true;
                    }
                }
            }

            count++;



        }
    }
}



