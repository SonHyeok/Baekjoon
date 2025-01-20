import java.io.*;
import java.util.StringTokenizer;

/**
 * 블록을 파서 인벤토리에 넣기 = 2초, 인벤토리에서 블록을 꺼내서 맞추기 = 1초
 * 최소한의 시간을 가져야 하기 때문에 위의 두 가지를 모두 실행했을때 더 빨리 끝나는 경우를 찾아야함 => DP
 * 먼저 인벤토리의 블록 존재 유무 파악이 필요함.
 * 가장 높은 층 or 가장 낮은 층 or 가장 동일 높이가 많은 층. 총 3가지 경우로 계산해본다.
 */
public class Main {
    static int[][] ground;

    static int resultTime = Integer.MAX_VALUE;
    static int resultHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ground = new int[row][col];

        // 땅 셋팅
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(num, min);
                max = Math.max(num, max);

                ground[i][j] = num;
            }
        }

        // 최소 높이부터 최대 높이까지 모두 측정하면서 적정값을 찾음
        for (int i = min; i <= max; i++) {
            int curTime = 0;
            int curBlock = block;

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    int now = ground[j][k];

                    // 현재 블록의 높이가 i보다 낮은 경우
                    if (now < i) {
                        // 채워야 하는 블록의 갯수
                        int diff = i - now;

                        // 현재 사용한 블럭 갯수 차감
                        curBlock -= diff;

                        // 현재까지 측정된 시간에 소요될 시간만큼 추가
                        curTime += diff;
                    }

                    // 현재 블록의 높이가 i보다 높은 경우
                    else if (now > i) {
                        // 빼내야 하는 블록의 갯수
                        int diff = now - i;

                        // 현재 추출한 블럭 갯수에 추가
                        curBlock += diff;

                        // 현재까지 측정된 시간에 소요될 시간만큼 추가( 2초 걸리는 작업이기에 2를 곱함)
                        curTime += (2 * diff);
                    }
                }
            }

            // 사용한 블록의 갯수가 0보다 작을 경우
            if (curBlock < 0) {
                continue;
            }

            // 총 소요 시간이 같은 경우, 더 높은 높이를 선정
            if (resultTime == curTime) {

                // 더 높은 높이를 선정
                resultHeight = Math.max(resultHeight, i);
            }

            // 총 소요시간이 이전에 측정한 시간보다 짧을 경우
            else if (resultTime > curTime) {
                // 결과 시간을 저장
                resultTime = curTime;

                // 결과 높이를 저장
                resultHeight = i;
            }
        }

        bw.write(resultTime + " " + resultHeight);

        bw.flush();
        bw.close();
        br.close();
    }

}
