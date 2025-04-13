import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int M,N;
    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        list = new int[M];

        dfs(0,1);
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int depth, int at) throws IOException {
        if (depth == M) {
            for (int n : list) {
                bw.write(n + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
                list[depth] = i;
                dfs(depth + 1, i + 1);
        }
    }
}
