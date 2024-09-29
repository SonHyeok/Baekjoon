import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     * 이항 계수 문제
     * N과 k의 이항 계수 (N\K) 구하기
     * N! / (N - K)! * K!
     * factorial 함수 필요
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        bw.write(factorial(n) / (factorial(n - k) * factorial(k)) + "\n");
        bw.flush();
        bw.close(); br.close();
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }
}