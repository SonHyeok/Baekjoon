import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    /**
     * 최대 공약수로 나눈 수를 최대 공약수와 곱하면 최소 공배수가 나옴
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int mini = minimum(num1, num2);
        int maxi = (num1 / mini) * (num2 / mini) * mini;

        System.out.println(mini);
        System.out.println(maxi);
    }

    public static int minimum(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return minimum(num2, num1 % num2);
        }
    }
}