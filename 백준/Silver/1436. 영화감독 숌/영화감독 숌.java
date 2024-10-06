import java.io.*;

public class Main {

    /**
     * 666을 제외한 자리에는 0~9까지 들어갈 수 있음(맨 앞자리는 1~9)
     */
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 찾으려는 수
        int num = Integer.parseInt(br.readLine());
        int count = 666;
        int total = 1;
        while (num != total) {
            count++;

            if (String.valueOf(count).contains("666")) {
                total++;
            }
        }
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close(); br.close();
    }
}




