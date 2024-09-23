import java.io.*;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int list1_length = Integer.parseInt(st.nextToken()); // 첫번째 배열의 길이
        int list2_length = Integer.parseInt(st.nextToken()); // 두번째 배열의 길이
        int[] total_list = new int[list1_length + list2_length]; // 두 배열의 길이를 합친 최종 배열

        st = new StringTokenizer(br.readLine()); // 첫번째 배열에 저장할 정수 입력
        for (int i = 0; i < total_list.length; i++) {
            total_list[i] = Integer.parseInt(st.nextToken()); // 바로 최종 배열에 추가

            if(i == list1_length - 1){
                st = new StringTokenizer(br.readLine()); // 두번ㅉ ㅐ배열에 저장할 정수 입력
            }
        }

        sort(total_list);

        for (int i : total_list) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
