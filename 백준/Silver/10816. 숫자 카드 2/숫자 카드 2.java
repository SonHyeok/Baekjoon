import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int card1 = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드
        int[] list = new int[card1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card1; i++) {
            list[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(list);

        int card2 = Integer.parseInt(br.readLine()); // 찾으려는 숫자 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card2; i++) {
            int findNum = Integer.parseInt(st.nextToken());

            int upperNum = upperBound(list, findNum);
            int lowerNum = lowerBound(list, findNum);

            bw.write(upperNum - lowerNum + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int upperBound(int[] list, int key) {
        int high = list.length;
        int low = 0;

        while (low < high) {
            int mid = (high + low) / 2;

            if (key < list[mid]) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    public static int lowerBound(int[] list, int key) {
        int high = list.length;
        int low = 0;

        while (low < high) {
            int mid = (high + low) / 2;

            if (key <= list[mid]) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


}
