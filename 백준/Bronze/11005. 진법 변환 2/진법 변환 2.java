import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 16,8 ~ n진수 -> 10진수로 변경
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int formation = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remain = num % formation;

            if (remain >= 10 && remain <= 35) {
                char word = (char) ('A' + remain - 10); // 10이상의 수는 문자로 처리
                sb.insert(0, word); // 스택처럼 선입선출이여야 하기에 뒤의 계산 결과를 앞으로 넣음
            }else{
                sb.insert(0,remain); // 스택처럼 선입선출이여야 하기에 뒤의 계산 결과를 앞으로 넣음
            }
            num = num / formation;
        }
        System.out.println(sb));
    }
}

