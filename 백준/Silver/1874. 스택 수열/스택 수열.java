import java.io.*;
import java.util.Stack;


/**
 * 입력받을 숫자의 개수 N입력
 * 숫자를 입력받으면 오름차순으로 해당 숫자만큼 요소를 차례대로 추가한다. 이 때 더한 만큼 +를 출력한다.(이미 추가된 숫자일 경우 생략). 이후 입력된 숫자가 스택 최상단에 있을 때 해당 숫자를 뺀다( - 출력).
 * 수열을 만들기 위해 입력받은 수 value보다 스택의 최상단 숫자가 클 경우 해당 스택은 원하는 수열을 만들 수 없기 때문에 NO를 출력한다. (왜 못만들지?)
 * -> 그 이유는 value가 3이고, 스택에는 3,4 이렇게 저장되어 있다면 4를 먼저 빼야 하는데, 그럼 3의 자리에 4가 나오기 때문에 원하는 수열을 만들지 못한다...
 * 스택의 최상단 숫자가 value와 같을 경우 스택에서 숫자를 빼고 -를 출력한다.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        // 오름차순 숫자가 어디까지 입력되었는지 확인하기 위한 변수
        int start = 0;

        while (N-- > 0) {

            int value = Integer.parseInt(br.readLine());

            // 현재까지 입력된 오름차순 수가 사용자가 찾는 수보다 작을 경우 찾는 수까지 스택에 오름차순 수 추가
            if (start < value) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }

                // 어디까지 입력되었는지 확인하기 위해서 start 변수 업데이트
                start = value;
            }
            // 스택에서 다음에 빠질 수가 찾는 수가 아닌 경우 입력된 수열을 만들 수 없기때문에 NO 출력
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            // 현재까지 입력된 수가 사용자가 찾는 수보다 크고, 입력된 수열을 만들 수 있는 다음 숫자일 경우
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);;
        br.close();
    }
}
