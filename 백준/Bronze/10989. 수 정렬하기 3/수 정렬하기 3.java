import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] numList = new int[10001];

        for (int i = 0; i < count; i++) {
            numList[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10001; i++) {
            while (numList[i] > 0) {
                bw.write(i + "\n");
                numList[i]--;
            }
        }

        bw.flush();
        bw.close(); br.close();
    }
}