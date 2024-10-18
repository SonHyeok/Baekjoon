import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 8 x 8 체스판을 만들어야 하므로 총 칸수는 64개
     * 검은색 시작 체스판, 하얀색 시작 체스판의 최소 개수를 더하면 64가 나옴
     * 즉, 한 종류의 최소 경우만 찾아서 64에서 뺀 값과 비교, 그 중 더 작은 값이 최소 경우임.
     * 여기서 전제 조건은 8 x 8 체스판 생성이 가능한 모든 경우를 먼저 검사해서 최소 경우를 구한다는 전제가 필요함.
     *
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[] board = new String[row];


        // 체스판 입력 데이터로 생성
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        // 체스판 자르기
        int sol = Integer.MAX_VALUE;

        //row - 8 => 8 x 8 크기 체스판을 만들 수 있는 마지막 row 지점
        // col - 8 => 8 x 8 크기 체스판을 만들 수 있는 마지막 col 지점
        // 체스판을 만들수 있는 마지막 지점까지 검사하면서 최소 값 구하기
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {

                // 현 체스판의 최소 비용 구하기
                int curSol = getSolution(i, j, board);

                // 최소 비용 값 할당
                if(sol > curSol) sol = curSol;

            }
        }
        bw.write(String.valueOf(sol));
        bw.flush();
        bw.close(); br.close();

    }

    public static int getSolution(int startRow, int startCol, String[] board) {
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"}; // W로 시작하는 경우 짝수, 홀수 행의 체스판(답안) 생성
        int whiteSol = 0;

        for (int i = 0; i < 8; i++) { // (0,0)이 아닌 시작 지점에서 체스판 만들기
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != orgBoard[row % 2].charAt(j))  { // 현재 체스판 위치의 값과 답안으로 작성한 체스판의 위치 값 비교
                    whiteSol++;
                }
            }
        }

        return Math.min(whiteSol, 64 - whiteSol);
    }


}
