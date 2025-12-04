import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        int[][] graph = new int[count + 1][count + 1];
        boolean[] visited = new boolean[count + 1];

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 그래프 세팅
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        dfs(graph, visited, 1);

        bw.write(String.valueOf(total));
        bw.flush();
    }

    static void dfs(int[][] graph, boolean[] visited, int k){
        visited[k] = true;

        for (int i = 0; i < graph[k].length; i++) {
            if(graph[k][i] == 1 && !visited[i]){
                total++;
                dfs(graph, visited, i);
            }
        }
    }
}
