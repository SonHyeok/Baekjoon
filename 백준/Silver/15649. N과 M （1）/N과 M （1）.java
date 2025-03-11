import java.io.*;
import java.util.*;

/**
 * 입력 N과 M
 * 1부터 N까지 M개의 숫자로 이루어진 수열을 만들어야 함
 * 입력 숫자가 3 2인 경우 -> 최대 값이 3인 수열이며 2가지의 수로 이루어진 수열이다.
 * EX) 1 2, 1 3, 2 3
 */
public class Main {

    static int[] arr;

    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);

        bw.flush();
        bw.close();
        br.close();
    }


    static void dfs(int N, int M, int depth) throws IOException {

        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {

                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);

                visited[i] = false;
            }
        }
        return;
    }

}
