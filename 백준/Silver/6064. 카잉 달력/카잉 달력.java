import java.io.*;
import java.util.StringTokenizer;

/**
 *  modulo 연산 적용 문제
 *  해를 가리키는 변수를 j로 설정
 *  j 가 M이나 N으로 나누었을때 0이 되면 원하는 해를 구할 수 없기에 x,y,j에 1씩 뺀 후 modulo 연산 수행
 *  이후 결과에 1을 더해준다.
 * 
 * 최대 연산 횟수는 M과 N의 최소 공배수 이하에 count를 곱한 값이기에 O(N * count)이다.
 * 추후 최대 공배수 적용한 조건문으로 풀이 필요하다.
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int M,N,x,y;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            boolean flag = false;

            for (int j = x; j < M * N; j += M) {

                if (j % N == y) {
                    flag = true;
                    bw.write((j + 1) + "\n");
                    break;
                }
            }

            if (!flag) {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
