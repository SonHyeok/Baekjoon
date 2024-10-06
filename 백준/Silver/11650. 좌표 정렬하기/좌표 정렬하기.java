import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * x 좌표 순으로 정렬, x 좌표가 같을 경우 y 좌표 순으로 정렬
     * Comparator Or Comparable 활용
     */
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 좌표 갯수
        int count = Integer.parseInt(br.readLine());

        int[][] x_list = new int[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine()); // x 좌표 입력
            for (int j = 0; j < 2; j++) {
                x_list[i][j] = Integer.parseInt(st.nextToken()); //y좌표 입력
            }
        }

        Arrays.sort(x_list, (s1, s2) ->{ // 오름차순 정렬
            if (s1[0] == s2[0]) { // x 좌표가 같을 경우
                return s1[1] - s2[1]; // y좌표로 정렬함
            }
            else{
                return s1[0] - s2[0];
            }
        });


        for (int[] list : x_list) {
            bw.write(list[0] + " " + list[1] + "\n");
        }

        bw.flush();
        bw.close(); br.close();
    }
}




