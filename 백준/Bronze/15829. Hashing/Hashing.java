import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int SM = 31;
        long LM = 1234567891;

        int N = Integer.parseInt(br.readLine());
        char[] list = br.readLine().toCharArray();
        int[] numList = new int[N];

        long total = 0;

        for (int i = 0; i < N; i++) { // 문자 -> 숫자로 변경
            numList[i] =  (list[i] - 96);
        }

        for (int i = 0; i < N; i++) {
            int cur = (int) Math.pow(SM, i); // 제곱 수

            total += (numList[i] * cur); // 합계 계산

        }

        // 큰 수로 나누기
        long result =  (total % LM);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();


    }


}
