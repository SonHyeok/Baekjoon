import java.io.*;
import java.util.StringTokenizer;
public class Main {

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int list1_length = Integer.parseInt(st.nextToken());
        int list2_length = Integer.parseInt(st.nextToken());

        int[] list1 = new int[list1_length];
        int[] list2 = new int[list2_length];

        st = new StringTokenizer(br.readLine()); // 첫번째 배열에 요소 추가
        for (int i = 0; i < list1_length; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // 두번째 배열에 요소 추가
        for (int i = 0; i < list2_length; i++) {
            list2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // 포인터로 활용될 변수 선언
        int i = 0; 
        int j = 0;

        //정렬하면서 최종 배열에 요소 추가함
        while (i < list1_length && j < list2_length) {
            if (list1[i] <= list2[j]) {
                sb.append(list1[i++]).append(" ");
            }else{
                sb.append(list2[j++]).append(" ");
            }
        }

        // 요소 추가후 남은 요소들 추가
        while (i < list1_length) {
            sb.append(list1[i++]).append(" ");
        }

        while (j < list2_length) {
            sb.append(list2[j++]).append(" ");
        }

        // 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
