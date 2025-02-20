import java.io.*;
import java.util.*;

/**
 * 현재 위치에서 갈 수 있는 위치 3곳 (왼, 오, X2)
 * 해당 위치들로 이동 했을때, 가장 짧은 시간이 걸리는 방향으로 진행
 * 넓이 우선 탐색으로 진행하면 된다고 판단
 * 시간 복잡도는 0 ~ 100000의 범위 내에서 100000회 이하의 횟수로 탐색하기에 O(N)으로 판단
 *
 */
public class Main {

    static int[] check = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int me;
    static int bro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        me = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        if(me == bro){ bw.write(String.valueOf(0));}
        else{
            bfs(me);
            bw.write(String.valueOf(check[bro]));
        }



        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {

        // 시작 위치
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();

        // 시작 위치 큐에 추가
        queue.offer(start);

        while (!queue.isEmpty()) {
            // 현재 위치
            Integer now = queue.poll();

            visited[now] = true;

            if (now + 1 < check.length && check[now + 1] == 0) {
                check[now + 1] = check[now] + 1;
                queue.offer(now + 1);
            }

            if (now - 1 >= 0 && check[now - 1] == 0) {
                check[now - 1] = check[now] + 1;
                queue.offer(now - 1);
            }

            if (now * 2 < check.length && check[now * 2] == 0) {
                check[now * 2] = check[now] + 1;
                queue.offer(now * 2);
            }
        }
    }
}
