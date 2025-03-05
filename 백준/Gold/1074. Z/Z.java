import java.io.*;
import java.util.StringTokenizer;

/**
 * N x N 크기의 블록을 2 x 2 크기가 될때까지 재귀적으로 4등분
 * 이후 2x2 크기의 블록마다 z자 탐색 진행
 * 4등분 한 이후 1,2,3,4사분면 중 어느곳에 목표 좌표가 존재하는지 확인.
 * 확인된 사분면에 대해서 재귀함수 실행
 *
 */
public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 2의 N제곱
        int M = (int) Math.pow(2, N);

        recur(M, row, col);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }


    static void recur(int size, int row, int col) {
        if (size == 1) {
            return;
        }

        // 2의 N-1 제곱은 2의 배수이기에 2씩 나눈 크기로 4등분
        int half = size / 2;

        if ((row >= 0 && row < half) && (col >= 0 && col < half)) { // 1사분면
            recur(half, row, col);
        }

        else if ((row >= 0 && row < half) && (col >= half && col < size)) { // 2사분면
            count += half * half; // 1 사분면 칸의 갯수 추가
            recur(half, row, col - half); // 1사분면에서 진행하는 것처럼 하기 위해, 1사분면의 좌표로 맞춰줌
        }

        else if ((row >= half && row < size) && (col >= 0 && col < half)) { // 3사분면
            count += (half * half) * 2; // 1,2 사분면 칸의 갯수 추가
            recur(half, row - half, col);// 1사분면에서 진행하는 것처럼 하기 위해, 1사분면의 좌표로 맞춰줌

        } else if ((row >= half && row < size) && (col >= half && col < size)) { // 4사분면
            count += (half * half) * 3; // 1,2,3사분면 칸의 갯수 추가
            recur(half, row - half, col - half);// 1사분면에서 진행하는 것처럼 하기 위해, 1사분면의 좌표로 맞춰줌
        }
        // 각 좌표에 size의 반을 빼는 이유 => size만큼 빼버리면 음수가 되면서 indexOutOfRange 발생, 따라서 4등분한 사각형의 크기만큼만 빼줘야함.
        //  2의 n-1 제곱의 크기로 4등분을 해야 하는데, 2의 n-1 제곱이 2의 배수이기에 size를 2로 나눈 값을 빼는 것.
        
        
    }

}
