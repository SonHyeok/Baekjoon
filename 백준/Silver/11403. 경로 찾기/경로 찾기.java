import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        graph = new int[count][count];

        for (int i = 0; i < count; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < count; k++) {
                graph[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if ( graph[i][k] == 1 && graph[k][j] == 1) {

                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {

                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}



