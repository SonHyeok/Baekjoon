import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int cur1 = list[i];

            for (int j = i + 1; j < N; j++) {
                int cur2 = cur1 + list[j];

                for (int k = j + 1; k < N; k++) {
                    int cur3 = cur2 + list[k];

                    if (cur3 > max && cur3 <= M) {
                        max = cur3;
                    }
                }
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();


    }


}
