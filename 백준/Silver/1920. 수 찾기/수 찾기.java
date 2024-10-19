import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     *  1 <= N,M <= 100,000
     *  배열 A,B는 각각 N과 M의 크기를 따라감
     *  최악의 경우 100,000개의 데이터에 대해 100,000번 비교해서 데이터를 찾아야 하는 경우가 발생 => O(N^2)
     *  정수의 범위는 int형의 범위와 같은 => 4byte == 32bit
     *
     *  최악의 경우에는 10,000,000,000번의 연산이 발생하므로 제한 시간인 1초가 넘어간다...
     *  따라서 배열의 모든 원소를 비교하는 것 대신 이분 탐색을 진행하여 시간 복잡도를 개선한다.
     *  왜냐하면 결국 M 리스트의 원소를 N리스트에서 찾아야 하는 탐색이기 때문이다!
     *  따라서, 찾아야 하는 key값을 주고 그 값을 N 리스트에서 이분 탐색으로 찾도록 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[] listA = new int[count];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(listA);

        count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            if (myBinarySearch(listA, Integer.parseInt(st.nextToken())) >= 0) {
                bw.write(1 + "\n");
            }else{
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int myBinarySearch(int[] list, int key) {

        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2; // 중간 위치 구하기

            if (key > list[mid]) { // 찾으려는 키 값이 중간 값보다 클 경우
                low = mid + 1;
            } else if (key < list[mid]) { // 찾으려는 키 값이 중간 값보다 작을 경우
                high = mid - 1;
            }else{ // key 값과 중간 값이 같을 경우
                return mid;
            }
        }

        return -1;
    }
}




