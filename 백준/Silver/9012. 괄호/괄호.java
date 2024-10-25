import java.io.*;
import java.util.Stack;

public class Main {

    /**
     * 스택에 괄호들만 넣어서 비교하기
     * 왼쪽 소괄호들을 먼저 넣다가 오른쪽 소괄호가 비교 대상이 되면 스택에서 왼쪽 소괄호들을 꺼내서 짝 수를 맞춘다
     * 시간 복잡도는 O(1 * N) = O(N)이다.
     * 문자열의 길이가 2 ~ 50이기에 최대 50번 반복하므로 O(1), 입력 갯수가 N개로 많아질 수 있기에 O(N)
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.valueOf(br.readLine());

        for (int i = 0; i < count; i++) {
            boolean isBalanced = true; // 균형 맞는지 확인하는 flag
            String input = br.readLine();
            Stack<Character> chars = new Stack<>();

            for (char c : input.toCharArray()) {
                if(c == '('){ // 왼쪽 소괄호인 경우 스택에 저장
                    chars.push(c);
                }
                else{ // 오른쪽 소괄호일 경우
                    if (chars.isEmpty() || chars.peek() != '(') { // 스택이 비어있거나 괄호 짝이 맞지 않는 경우
                        isBalanced = false;
                        break;
                    }
                    chars.pop(); // 괄호 짝이 맞을 경우 pop
                }
            }

            if(!isBalanced || !chars.isEmpty()){ // 괄호 짝이 안맞는다면 NO 저장
                sb.append("NO\n");
            } else{ // 괄호 짝이 맞는다면 스택이 비어있을 것이기 때문에 2가지 조건 모두 검사 후 YES 저장
                sb.append("YES\n");
            }
        }

        System.out.print(sb);
    }
}





