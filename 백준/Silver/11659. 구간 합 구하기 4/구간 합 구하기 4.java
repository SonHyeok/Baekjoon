import java.io.*;
import java.util.StringTokenizer;

// 5 9 12 14 15
/**
 * 순수하게 입력받은 숫자를 배열에 저장하지 말고 입력받으면서 누적합을 배열에 저장함.
 * 이후 start, end index를 받는다.
 * 반복문 중첩을 사용하면 시간초과가 발생함.
 * 따라서 누적합 배열에서 end 인덱스의 값에 start 인덱스 - 1의 값을 뺀다.
 * 왜냐하면 start 전까지의 누적합을 end까지의 누적합에서 빼는 것이기 때문이다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받을 숫자 개수
        int N = Integer.parseInt(st.nextToken());

        // 반복할 횟수
        int K = Integer.parseInt(st.nextToken());

        // 숫자 저장할 배열
        int[] list = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        // 누적합을 배열에 저장하기 위한 누적 합 변수
        int cost = 0;

        for (int i = 1; i <= N; i++) {

            cost += Integer.parseInt(st.nextToken());
            list[i] = cost;
        }


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(list[end] - list[start - 1] + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }




}

