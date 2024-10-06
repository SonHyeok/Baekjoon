import java.io.*;
import java.util.Arrays;

public class Main {

    /**
     */
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] list = new int[count];

        for (int i = 0; i < count; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(list, 0, list.length - 1);

        for (int i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close(); br.close();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (high + low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        // 병합할 배열의 크기 설정
        int[] merged = new int[high - low + 1];
        
        int i = low;
        int j = mid + 1;
        int idx = 0;

        // 두 하위 배열을 병합
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                merged[idx] = arr[i];
                i++; idx++;
            }else{
                merged[idx] = arr[j];
                idx++; j++;
            }
        }

        while (i <= mid) { // 왼쪽 하위 배열에 남은 요소 복사
            merged[idx] = arr[i];
            i++; idx++;
        }

        while (j <= high) { // 오른쪽 하위 배열에 남은 요소 복사
            merged[idx] = arr[j];
            idx++;
            j++;
        }

        // 병합된 배열을 원본 배열에 복사
        System.arraycopy(merged, 0, arr, low, merged.length);

    }
}




