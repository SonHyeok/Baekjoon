import java.io.*;

import java.util.*;


/**
 * 입력 수 N과 int 리스트
 * 짧은 인출시간 순서로 정렬 후 각 사람마다 인출하는데 걸린 시간 계산
 * 이후 계산된 시간을 총합
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] timeList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            timeList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeList);

        int mid = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            mid += timeList[i];
            total += mid;
        }

        bw.write(String.valueOf(total));
        
        bw.flush();
        bw.close();
        br.close();
    }
}

