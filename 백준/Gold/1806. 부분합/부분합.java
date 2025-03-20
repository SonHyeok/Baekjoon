import java.io.*;
import java.util.*;

/**
 * 투포인터 문제
 * start와 end를 사용해서 15 이상이 되는 조합을 찾을 때 까지 end를 증가시킴,
 * 이후 15이상이 되면 start 지점을 1올리고, 이전 start 지점의 수를 뺌.
 * 위 과정을 반복
 * 과정을 반복하면서 15가 되는 수열의 길이가 가장 짧은 경우를 찾아낼 것
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = 100001;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (start <= N && end <= N) {
            if (sum < S) {
                sum += list[end++];
            }
             else {
                minLength = Math.min(minLength, end - start);
                sum -= list[start++];
            }
        }

        if (minLength == 100001) {
            bw.write(String.valueOf(0));
        } else {
            bw.write(String.valueOf(minLength));

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
