import java.io.*;

public class Main {

    /**
     * 팩토리얼 값을 소인수 분해하면 꼭 2 x 5가 포함됨.
     * 2 x 5 = 10이므로, 0으로 끝나면 10으로 나눌 수 있다는 뜻.
     * 팩토리얼 값을 10으로 나누면 좋긴 하나, 13!을 넘어가면 BigInteger를 사용해야 하는 상황 발생(= 번거로움)
     * 2는 소인수 분해하면 너무 작게 나눠지기에 5로 나누기로 결정
     * 5의 개수에 따라 값이 변화함. 5의 n승에 따라 카운트 값을 추가 할 것 => 단순히 5로 나눌게 아닌 반복문으로 5로 나누면서 누적합 필요
     * 팩토리얼 계산조차 할 필요가 없어짐.
     */
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n >= 5) { // 5로 나누면서 누적합 더함
            count += n / 5;
            n /= 5;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close(); br.close();
    }

}




