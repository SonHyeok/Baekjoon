import java.io.*;
import java.util.StringTokenizer;


/**
 * 먼저 String 타입의 그래프를 생성
 * 이후 입력받은 값들로 초기화 진행
 * I를 찾으면 상하좌우로 탐색 진행
 * 탐색 진행중 벽을 만난다면 해당 방향은 탐색 중단
 * 만약 P를 만난다면 카운트 추가
 */
public class Main {

    static char[][] graph;
    static boolean[][] visited;

    // 상,하,좌,우 움직임을 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 입력받을 그래프의 행,열
    static int row, col;

    // 결과 카운트
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new char[row][col];

        // 방문 배열 초기화
        visited = new boolean[row][col];

        // 도연이의 위치를 저장할 변수
        int cx = 0;
        int cy = 0;

        // 문자열을 입력받아서 배열로 저장
        for (int i = 0; i < row; i++) {
            char[] charList = br.readLine().toCharArray();

            for (int j = 0; j < col; j++) {
                graph[i][j] = charList[j];

                // 도연이의 위치를 저장
                if (charList[j] == 'I') {
                    cy = i;
                    cx = j;
                }
            }
        }

        // 깊이우선 탐색 실행
        dfs(cy, cx);

        // 결과에 따른 출력값 작성
        if (count == 0) {
            bw.write("TT");
        }
        else{
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static void dfs(int y, int x) {
            // 방문 체크
            visited[y][x] = true;

            // 상,하,좌,우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 그래프 벗어남, 벽, 이미 방문한 곳 패스
                if (nx < 0 || ny < 0 || nx >= col || ny >= row) {
                    continue;
                }

                if (graph[ny][nx] == 'X' || visited[ny][nx]) {
                    continue;
                }

                // 사람을 만났을 경우 카운트
                if (graph[ny][nx] == 'P') {
                    count++;
                }

                dfs(ny, nx);
            }
    }
}

