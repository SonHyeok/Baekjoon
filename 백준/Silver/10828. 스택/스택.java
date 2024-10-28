import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /**
     * 단순 스택 문제
     * 명령은 push, top, pop, empty, size가 있음
     * pop 명령시 스택이 비어있으면 -1 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());
        Stack<String> stack = new Stack<>();
        int top = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) { //push 명령시
                String element = st.nextToken();

                stack.push(element); // 요소를 스택에 추가
                top = Integer.parseInt(element); // top을 추가된 요소로 변경
            }
            else if (command.equals("top")) { // top 명령시
                bw.write(top + "\n"); // top 출력
            }
            else if (command.equals("pop")) { // pop 명령시
                if (stack.isEmpty()) { // 스택이 비어있을 경우 -1 출력
                    bw.write("-1\n");
                }else{ // 스택이 비어있지 않을 경우
                    bw.write(stack.pop() + "\n"); // 스택에 있는 요소 pop

                    if (stack.isEmpty()) { // pop 이후 스택이 비어있을 경우 top을 -1로 변경
                        top = -1;
                    }else{ // 아닐 경우 top에 다음 요소 대입
                        top = Integer.parseInt(stack.peek());
                    }
                }
            }
            else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }
            else{
                bw.write(stack.size() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}





