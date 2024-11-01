import java.io.*;
import java.util.*;

public class Main {

    /**
     * 1번부터 입력받은 수 N번 까지의 배열 생성
     * 이후 입력받은 수 k를 변수에 저장
     * 배열에서 K번째를 계속 제거하면서 변경된 배열 크기에 맞게 k번째를 계속해서 제거
     * 제거된 숫자는 큐에 저장
     * 숫자가 제거된 배열은 재배치되면서 숫자가 앞으로 당겨짐. 그게 인덱스 +1 하는 효과가 생기기에 K만큼 인덱스를 증가시키면서 숫자를 제거하면 안되고, k-1만큼 증가시켜야 함.
     * 1 <= k,n <= 1000
     * 따라서 시간 복잡도는 최대 1000 * 1000 => O(1)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        List<Integer> numbers = new ArrayList<>(); // 리스트의 크기가 동적으로 변경되어야 하기에 List 자료구조 사용
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) { // 숫자 배열 생성
            numbers.add(i);
        }

        // 배열 순회할 인덱스 변수 설정
        int index = 0;

        // index는 배열 크기보다 커지면, modulo 연산을 통해서 조절
        // index % list.size()
        while (numbers.size() != 0) {
            index = (index + (K - 1)) % numbers.size(); // 숫자를 제거하면서 인덱스가 +1되는 상황이 생기기에 k-1씩 증가시키면서 숫자 제거
            Integer removed = numbers.remove(index);
            queue.offer(removed);
        }

        int size = queue.size(); // queue.size()를 for문 크기 조건으로 걸면 큐의 원소가 빠지면서 반복문 횟수가 줄어들기 때문에 변수에 따로 저장
        bw.write("<"); // 출력 형식을 위한 맨 앞 괄호 추가
        for (int i = 0; i < size; i++) {
            if (i == size - 1) { // 마지막 원소일 경우 뒤에 ,와 공백을 추가하지 않음.
                bw.write(String.valueOf(queue.poll()));
            }else{

                bw.write(queue.poll() + ", ");
            }
        }
        bw.write(">");// 출력 형식을 위한 맨 뒤 괄호 추가

        bw.flush();
        bw.close();
        br.close();
    }
}




