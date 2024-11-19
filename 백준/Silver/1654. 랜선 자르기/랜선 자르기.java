import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 현재 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
 * 가지고 있는 랜선 K개를 입력받고 해당 랜선들로 N개의 랜선들을 만들수 있는 최대 길이
 * 구한 길이로 랜선들을 나눠서 몫을 구해본 후, 그 합이 N보다 크거나 같으면, 길이를 올려보면서 N개보다 작아질 때 까지 연산
 * 첫 중간값은 0과 가장 긴 랜선을 더한 후 반으로 나눠서 설정
 *
 * 이분 탐색을 응용해서 풀어보기
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가지고있는 랜선 갯수
        int K = Integer.valueOf(st.nextToken());

        // 목표 랜선 갯수
        int N = Integer.valueOf(st.nextToken());

        //가지고 있는 랜선 길이 배열
        int[] numList = new int[K];

        // 최대값 , 최소값
        long max = 0;
        long min = 0;

        for (int i = 0; i < K; i++) {
            Integer inputNum = Integer.valueOf(br.readLine());
            numList[i] = inputNum;

            if (max < inputNum) {
                max = inputNum;
            }
        }

        // upper bound는 구하려는 숫자보다 1개 인덱스가 더 큰 수를 찾기에 +1 진행
        max++;

        while (min < max) {

            // 보유한 랜선을 잘라서 획득한 랜선 갯수
            long count = 0;

            // 중간 값
            long mid = (max + min) / 2;

            // 중간 값으로 랜선들을 잘라서 나온 갯수의 합 구하기
            for(int num : numList){
                count += (num / mid);
            }

            /*
             *  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */

            // 구한 랜선 갯수가 목표 갯수보다 작을 경우
            if(count < N){
                max = mid;
            }
            else{ // 구한 랜선 갯수가 목표 갯수보다 크거나 같을 경우( 1씩 늘리면서 목표 갯수를 구하는 범주에서 최대 랜선 길이를 파악)
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(max - 1));

        bw.flush();
        bw.close();
        br.close();
    }



}
