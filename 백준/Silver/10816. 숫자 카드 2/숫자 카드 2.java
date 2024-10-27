import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * 1 <= N,M <= 500,000
     * 각 입력되는 수는 - 10,000,000 ~ 10,000,000 사이의 크기
     * N개의 입력된 수에 M개의 입력된 수가 얼마나 포함되어 있는지 확인하기
     * HashMap을 사용해서 처음 N개 입력 받을때 각 수가 몇개씩 입력 받았는지 입력 받은 숫자를 KEY, 개수를 VALUE로 설정
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        Map<Integer, Integer> numbers = new HashMap<>();

        String[] nums = br.readLine().split(" "); // 숫자들을 입력받음
        
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(nums[i]); // int형으로 캐스팅

            if (numbers.containsKey(num)) { // 숫자가 존재할 경우
                numbers.put(num, numbers.get(num) + 1);
            }else{ // 숫자가 없을 경우
                numbers.put(num, 1);
            }
        }

        int M = Integer.valueOf(br.readLine());
        nums = br.readLine().split(" "); // 숫자들을 입력받음

        for (int i = 0; i < M; i++) {
            int num = Integer.valueOf(nums[i]); // int 형으로 캐스팅

            if (numbers.containsKey(num)) { // 숫자가 존재할 경우
                bw.write(numbers.get(num) + " ");
            }else{ // 숫자가 없을 경우
                bw.write(0 + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}





