import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 2차원 String 배열로 받아서, 나이만으로 정렬
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        String[][] list = new String[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = st.nextToken();
            list[i][1] = st.nextToken();
        }

        Arrays.sort(list, (s1, s2) -> Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]));

        for (int i = 0; i < count; i++) {
            bw.write(list[i][0] + " " + list[i][1] + "\n");
        }

        bw.flush();
        bw.close(); br.close();
    }

}