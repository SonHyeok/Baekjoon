import java.io.*;
import java.util.Stack;

public class Main {

    /**
     * 데이터를 계속 넣다가 0이 입력되면 가장 최근 데이터를 삭제함. 그리고 0이 입력되었을 때 삭제하는 경우, 삭제할 데이터가 있다는 것을 보장받아야 함.
     * 입력 데이터 K번 만큼 반복문을 반복하면서 데이터 삽입, 삭제 진행.
     * 이후 누적된 데이터의 총 합을 더한다.
     * K는 0보다 크고 100,000보다 작기에 시간 복잡도는 O(1)으로 예상한다.
     * 총합을 구할 때 스택 크기만큼 반복문을 다시 돌아야 하기 때문에 memoization을 사용해서 실시간으로 총합을 계산하면서 누적한다.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());
        int total = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int number = Integer.valueOf(br.readLine());

            if (number == 0 && stack.size() != 0) { // 0을 입력받고 스택이 비어있지 않을 경우
                total -= stack.pop(); // 가장 최근 데이터를 pop해서 총합에서 제거함
                continue;
            }
            stack.push(number); // 0이 아닌 경우 입력
            total += number; // 데이터 입력후 총합 누적
        }

        System.out.println(total);
    }
}





