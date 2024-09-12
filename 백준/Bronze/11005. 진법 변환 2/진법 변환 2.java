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
                char word = (char) ('A' + remain - 10);
                sb.append(word);
            }else{
                sb.append(remain);
            }
            num = num / formation;
        }
        System.out.println(sb.reverse());
    }
}

