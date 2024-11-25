import java.io.*;

import java.util.*;


/**
 * 입력 수 N,K
 * 1<= N <= 10, 1<= K <= 1,000,000
 * N개의 동전으로 K를 구하는 최소 동전 갯수 파악하기
 * K보다 작은 수 중에서 가장 큰 수로 몫을 구한 후 나머지를 파악한다.
 * 이후 파악한 나머지에 대해서 위의 과정을 반복.
 * 시간 복잡도는 N이 최대 10번이고 반복수도 N번만 하므로 O(1) 예상
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int[] coinList = new int[N];

        // 동전 저장
        for (int i = 0; i < N; i++) {
            int listLength = coinList.length - 1 - i;
            coinList[listLength] = Integer.parseInt(br.readLine());
        }

        for (int coin : coinList) {
            if (coin <= K) {
                count += K / coin;
                K %= coin;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}
