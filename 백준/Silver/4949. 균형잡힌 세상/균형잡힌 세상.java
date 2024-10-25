import java.io.*;
import java.util.Stack;

public class Main {

    /**
     * 스택에 괄호들만 넣어서 비교하기
     * 최대 시간 복잡도는 O(N); 왜냐? 무한으로 입력받기 가능하기에 N번 받는다 치고, 글자 수는 100보다 작기에 O(1 * N) = O(N)임
     *  괄호가 하나도 없는 경우는 균형잡힌 문자열로 간주하기에 비교 조건이 아님.
     *  짝이 맞지 않는 것을 확인할 때 pop이 아닌 peek을 사용하는 이유는 )( 이렇게 입력될 경우 pop을 하면 ( 괄호가 빠지기 때문에 스택이 비어서 균형 잡힌 것으로 간주되기 때문이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.charAt(0) == '.') { // . 입력될 경우 종료
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                break;
            }

            Stack<Character> words = new Stack<>();

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') { // 왼쪽 괄호일 경우 스택에 push
                    words.push(c);
                }
                else if (c == ')') { // 오른쪽 소괄호인 경우 스택에서 반대쪽 괄호 존재하는지 검사
                    if (words.isEmpty() || words.peek() != '(') {  // 만약 스택이 비었거나 반대 괄호가 아닌 경우 반복문 종료
                        words.push(c); // 반례인 ")" 만 입력으로 받은 경우 스택이 비어있기 때문에 yes가 나옴. 해당 사례를 방지하기 위해서 일부러 스택에 추가해서 no가 나오도록 유도
                        break;
                    }

                    words.pop(); // if조건에 안걸리면 스택에서 pop
                }
                else if (c == ']') { // 오른쪽 대괄호인 경우 스택에서 반대쪽 괄호 존재하는지 검사
                    if (words.isEmpty() || words.peek() != '[') { // 만약 스택이 비었거나 반대 괄호가 아닌 경우 반복문 종료
                        words.push(c);
                        break;
                    }
                    words.pop();
                }
            }

            if (words.isEmpty()) {
                sb.append("yes \n");
            }else{
                sb.append("no \n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}





