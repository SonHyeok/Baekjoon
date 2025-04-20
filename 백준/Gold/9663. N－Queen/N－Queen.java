import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 퀸은 가로, 세로, 대각선으로 이동 가능
 *
 *
 *
 *
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int count = 0;
    static int[] map; // 도시 정보
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new int[N];

        col = new boolean[N];
        diag1 = new boolean[N * 2 - 1];
        diag2 = new boolean[N * 2 - 1];

        backTrack(0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    static void backTrack(int row, int depth) {
        // 모든 행에 퀸을 배치했을 때, 경우의 수 +1 추가
        if (depth == N) {
            count++;
            return;
        }

        // 선택된 행의 모든 열 검사
        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + N - 1]) {
                continue;
            }

            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + N - 1] = true;

            backTrack(row + 1, depth + 1);

            col[c] =false;
            diag1[row + c] = false;
            diag2[row - c + N - 1] = false;

        }

    }
}
                
