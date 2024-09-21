import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int total = 0;
        boolean isNotDecimal = false;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num <= 1) {
                continue;
            }

            for (int k = 2; k <= num / 2; k++) {
                if (num % k == 0) { // 1이아닌 약수 발견 시 종료
                    isNotDecimal = true;
                    break;
                }
            }

            if (!isNotDecimal) {
                total++;
            }
            isNotDecimal = false;

        }

        System.out.println(total);
    }
}