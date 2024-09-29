import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] numList = new int[count];

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            numList[i] = num;
        }

        Arrays.sort(numList);
        for (int i : numList) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}