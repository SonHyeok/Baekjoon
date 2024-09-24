import java.io.*;

public class Main {

    /**
     * a-1 층의 1호부터 b호까지 사람 수 합친 값 필요
     * 각 i호에는 i명의 사람이 살고 있음.
     * ex: 2층의 3호에 거주하려고 함 -> a - 1 = 1, b = 3
     * 1층의 1,2,3호에 사는 사람 수 합쳐야 함.
     *
     * 1호 사람은 무조건 1명인 규칙 존재
     * 2호 사람은 아래층 2호 사람보다 1씩 커짐
     *
     * 현재 층 n호 + 아래층 n + 1호 더하면 현재 층의 다음 호수 값 나옴
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        // 방 개수 담을 2차원 배열 생성
        int[][] arr = new int[15][15];

        // 각 층 1호는 1로 셋팅, 1층은 호수에 맞게 사람 수 셋팅
        for (int i = 0; i < 15; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1 + i;
        }

        // 각 층의 i호와 아랫 층의 i+1호의 사람 수를 합치면 현재 층의 다음 호수 값이 나옴
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());

            if (room == 1) {
                bw.write(1 + "\n");
                continue;
            }

            bw.write(arr[floor][room - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
