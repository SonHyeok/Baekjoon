import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 간선을 이루는 점들의 좌표로 그래프를 구성
 * 모든 점을 확인하면서 방문하지 않은 점이 존재할 경우 탐색
 * 차례대로 점과 연결된 점들을 확인한 후, 다음 점과 연결된 점들을 확인할 때 방문 내역이 있는 점이 하나라도 존재할 경우,
 * 해당 점은 이전에 검사했던 점과 연결되어있음을 확인 가능함.
 */
public class Main {

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점과 간선
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        // 정점 갯수로 그래프 구성
        graph = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];
        visited[0] = true;

        // 결과 카운트
        int count = 0;

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 무방향 그래프 간선 연결
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        // 첫 번째 점부터 확인하면서 탐색
        for (int i = 1; i < vertex + 1; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        // 방문한 곳일 경우 패스
        if (visited[start]) {
            return;
        }

        // 방문하지 않은 곳일 경우 플래그 변경
        visited[start] = true;

        // DFS 탐색
        for (int i = 1; i < graph[start].length; i++) {
            if (graph[start][i] == 1) {
                dfs(i);
            }
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점 큐에 추가 후 방문 확인으로 변경
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 큐에 있는 요소 추출
            Integer now = queue.poll();

            for (int i = 1; i < graph[now].length; i++) {
                // 방문 이력이 없고, 점이 이어져 있다면 큐에 점을 추가후 방문 처리
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

