import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[]{0,0,-1,1};
    static int[] dx = new int[]{-1,1,0,0};

    static int X, Y;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        graph = new int[X][Y];
        visited = new boolean[X + 1][Y + 1];

        for (int x = 0; x < X; x++) {
            String[] maps = br.readLine().split("");
            for (int y = 0; y < Y; y++) {
                graph[x][y] = Integer.parseInt(maps[y]);
            }
        }

        bw.write(String.valueOf(bfs(0,0)));
        bw.flush();
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];
            int dist = now[2];

            if (cx == (X - 1) && cy == (Y - 1)) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
                    continue;
                }

                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }

        }

    return -1;
    }

}




