import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int startNum = 2;
        int square = 1;
        int total = 0;


        // n + (2 ** i)
        for (int i = 0; i < n; i++) {
            startNum += square;
            total = startNum * startNum;
            square *= 2;
//        System.out.println((int)Math.pow(2, i)); 해당 문장으로도 대체 가능
        }
        System.out.println(total);

    }
}

