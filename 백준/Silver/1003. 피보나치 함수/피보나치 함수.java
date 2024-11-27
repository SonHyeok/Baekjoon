import java.io.*;
import java.util.Timer;


/**
 * 피보나치 함수를 작성하고, 시간 단축을 위해서 각 단계를 기억하는 배열이 필요함
 * 다이나믹 프로그래밍의 개념과 메모이 제이션을 적용한다.
 * 또한 입력으로 0과 1을 받은 경우 각각 0과 1의 갯수에 + 1 적용
 *
 */
public class Main {
    // 0부터 T까지 크기의 리스트를 만들기 위해 T + 1 까지 배열 생성
    static Integer[][]  list = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 0번과 1번 인덱스는 0,0로 셋팅
        list[0] = new Integer[]{1,0};
        list[1] = new Integer[]{0,1};

        for (int i = 0; i < T; i++) { // 테스트 케이스 수만큼 반복
            // 테스트 케이스 입력 받아서 fibonacci 연산 수행
            int testCase = Integer.parseInt(br.readLine());
            fibonacci(testCase);

            bw.write(list[testCase][0] + " " + list[testCase][1]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 일반 피보나치와는 달리 0과 1의 출력 수를 구해야 함.
     * DP를 적용하기 위해서 각 테스트 케이스에 대한 0과 1의 출력 회수를 메모이제이션 적용
     */
    public static Integer[] fibonacci(int n) {
        if (list[n][0] == null || list[n][1] == null) {
            list[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            list[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return list[n];
    }
}

