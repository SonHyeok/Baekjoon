import java.io.*;
import java.util.StringTokenizer;

/**
 * 칸을 검사해서 색이 다를경우 정사각형을 네 개의 n/2 x n/2 크기를 가진 정사각형으로 나눈다
 * 위 과정을 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
 * 재귀함수를 사용해서 분할 정복 알고리즘 사용
 * 시간 복잡도는 2^1 ~ 2^7 사이의 값을 제곱한 크기를 탐색하기에 상수 시간 내에 종료된다.
 */
public class Main {
    static int[][] square;
    static int white = 0;
    static int blue = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        square = new int[size][size];

        // 배열 초기화
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(st.nextToken());
                square[i][j] = num;
            }
        }

        // 재귀함수 호출
        recur(0, 0, size);

        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    // 탐색 재귀 함수
    public static void recur(int row, int col, int size) {
        // 모든 칸의 색이 동일한 경우
        if (check(row, col, size)) {
            // 모든 칸이 파란색일 경우
            if (square[row][col] == 1) {
                blue++;

                // 모든 칸이 흰색일 경우
            } else {
                white++;
            }
            return;
        }

        // 모든 칸의 색이 동일하지 않을 경우 크기를 반으로 줄인 후 사각형 분리
        int newSize = size / 2;

        // 분리된 사각형 재귀 탐색
        recur(row, col, newSize);
        recur(row, col + newSize, newSize);
        recur(row + newSize, col, newSize);
        recur(row + newSize, col + newSize, newSize);
    }

    
    // 모든 칸의 색이 동일한지 검사
    public static boolean check(int row, int col, int size) {
        
        // 가장 첫번째 칸을 추출해서 다른 칸들과 비교
        int firstNum = square[row][col];
        
        // 모든 칸의 색이 같지 않을 경우 false 반환
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (firstNum != square[i][j]) {
                    return false;
                }
            }
        }
        // 모든 칸의 색이 같을 경우 true 반환
        return true;
    }
    
}
