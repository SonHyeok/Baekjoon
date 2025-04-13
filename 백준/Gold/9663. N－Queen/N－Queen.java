import java.io.*;

/**
 * 퀸은 가로,세로,대각선 방향으로 끝까지 이동 가능하다.
 * 행의 차와 열의 차가 같으면 대각선상에 위치하는 것이다.
 *
 * 1차원 배열로 풀이가 가능한데, 그 이유는 1차원 배열의 인덱스를 열로 생각하고 해당 인덱스의 값을 행으로 생각하는것이다.
 * 예를 들면 [0,3,2,1]인 경우 0번째 행의 0번째 열, 1번째 행의 3번째 열, 2번째 행의 2번째 열, 3번째 행의 1번째 열로 생각하는 것이다.
 * 이후 퀸이 움직이는 가로, 세로 및 대각선 방향으로 검사를 하고, 퀸을 배치가 가능한 경우 배치한다.
 */
public class Main {
    static int[] list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        list = new int[N];

        backTrack(0);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTrack(int depth) {
        // 퀸이 배치 가능한 위치에 모두 배치한 경우 1추가
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            list[depth] = i;
            // 다음 행에 퀸 배치가 가능한 경우 백트래킹 재귀 호출
            if (possibility(depth)) {
                backTrack(depth + 1);
            }
        }
    }

    static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치하는 경우 (= 같은 행에 존재할 경우)
            if (list[col] == list[i]) {
                return false;
            }
            // 대각선상에 존재하는 경우
            if (Math.abs(list[col] - list[i]) == Math.abs(col - i)) {
                return false;
            }

        }
        return true;
    }

}
