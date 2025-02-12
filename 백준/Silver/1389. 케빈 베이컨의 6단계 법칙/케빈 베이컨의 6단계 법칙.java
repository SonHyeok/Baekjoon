import java.io.*;
import java.util.*;

/**
 * 친구 관계를 그래프로 생성해서 사용
 * 시작점부터 도착점까지 가장 빠르게 도착할 수 있는 경우의 수를 구해야 함
 * 모든 경우의 수를 따져봐야 함
 * 출발점부터 경유지를 거쳐 도착점까지의 최단 거리를 구해야 하므로 플로이드-워샬 알고리즘 적용
 * 시간복잡도는 O(N^3)이기는 하나 유저의 수가 100이하인 경우이기에 100을 3제곱 하더라도 1백만에 가까움.
 * 나머지 부수적인 시간 복잡도들은 O(N) + O(N^2)의 시간이 걸림.
 * 따라서 해당 시간복잡도 내에 풀이가 가능함
 *
 */
public class Main {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int friends = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        graph = new int[friends + 1][friends + 1];

        // 그래프 초기화
        for (int i = 1; i <= friends; i++) {
            for (int j = 1; j <= friends; j++) {
                graph[i][j] = 99999;

                // (i,i)인 경우는 0
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 친구 관계 입력
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 그래프 생성
            graph[x][y] = graph[y][x] = 1;
        }

        // 중간점
        for (int k = 1; k <= friends; k++) {
            // 시작점
            for (int i = 1; i <= friends; i++) {
                // 도착점
                for (int j = 1; j <= friends; j++) {

                    // 현재 좌표까지 오는 거리가, 경유지를 거쳐서 오는 거리보다 더 멀 경우
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        // 케빈 베이컨 총합 값
        int total = Integer.MAX_VALUE;

        // 가장 총합이 적은 친구
        int friend = -1;

        for (int i = 1; i <= friends; i++) {
            int cur = 0;

            for (int j = 1; j <= friends; j++) {
                cur += graph[i][j];
            }

            if (total > cur) {
                total = cur;
                friend = i;
            }
        }

        bw.write(String.valueOf(friend));

        bw.flush();
        bw.close();
        br.close();
    }
}
