import java.io.*;
import java.util.*;


/**
 * 입력 값을 받아 그래프를 형성하고 단순히 DFS, BFS 알고리즘을 작성한다
 *
 */
public class Main {
    // 방문 기록 배열
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 갯수
        int count = Integer.parseInt(st.nextToken());

        // 쌍
        int pair = Integer.parseInt(st.nextToken());

        // 시작 점
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[count + 1];

        // 그래프 초기화
        for (int i = 0; i <= count; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력 받은 숫자 쌍으로 그래프 형성
        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex = Integer.parseInt(st.nextToken());
            int associated = Integer.parseInt(st.nextToken());

            graph.get(vertex).add(associated);
            graph.get(associated).add(vertex);
        }

        // 작은 수부터 탐색을 위한 정렬
        for (List<Integer> list : graph) {
            list.sort((n1,n2) -> {
                return n1 - n2;
            });
        }

        // 깊이 우선 탐색
        DFS(start);

        // 줄바꿈 이후 방문 검사 배열 초기화
        bw.write("\n");
        visited = new boolean[count + 1];

        // 넓이 우선 탐색
        BFS(start);

        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int start) throws IOException{
        // 시작점 추가
        visited[start] = true;
        bw.write(start + " ");
        
        // 연관된 정점들 깊이우선탐색 재귀적으로 실행
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    static void BFS(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점 추가
        queue.offer(start);
        visited[start] = true;
        bw.write(start + " ");

        while (!queue.isEmpty()) {
            // 현재 정점
            Integer now = queue.poll();

            // 연관된 정점들 방문했는지 검사 후 큐에 추가
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    bw.write(next + " ");
                    queue.offer(next);
                    visited[next] = true;
                }
            }

        }
    }
}



