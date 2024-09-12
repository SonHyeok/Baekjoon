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

        String num_list = st.nextToken();
        int formation = Integer.parseInt(st.nextToken());

        int total = 0;
        int count = 1;

        for (int i = num_list.length() - 1; i >= 0 ; i--) {
            char ch = num_list.charAt(i);

            if (formation == 10) {
                total = Integer.parseInt(num_list);
                break;
            }

            if (ch >= 'A' && ch <= 'Z') {
                total += (ch - 55) * count;
            }
            else {
                total += (ch - '0') * count;
            }
            count *= formation;
        }

        System.out.println(total);

    }
}

