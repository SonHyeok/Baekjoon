import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    /**
     * 단순 큐 문제이긴 하나 데이터를 뒤에서도 출력하기에 양방향인 Deque 자료구조 사용
     * 명령은 push, front, back, pop, empty, size가 있음
     * pop 명령시 큐가 비어있으면 -1 출력
     * 입출력이 많기때문에 LinkedList로 구현체 사용
     * 앞, 뒤에서 출력이 가능해야 하기 때문에 Deque를 사용함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());

        Deque<String> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) { //push 명령시
                String element = st.nextToken();

                queue.add(element); // 요소를 스택에 추가
            }
            else if (command.equals("front")) { // front 명령시
                if (!queue.isEmpty()) { // 큐가 비어있지 않을 경우
                    bw.write(queue.getFirst() + "\n"); // 맨 앞에서 요소 출력
                }else{
                    bw.write("-1\n"); // 큐가 비어있을 경우 -1 출력
                }
            }
            else if (command.equals("back")) { // back 명령시
                if (!queue.isEmpty()) { // 큐가 비어있지 않을 경우
                    bw.write(queue.getLast()  + "\n"); // 맨 뒤에서 요소 출력
                }else{
                    bw.write("-1\n"); // 큐가 비어있을 경우 -1 출력
                }
            }
            else if (command.equals("pop")) { // pop 명령시
                if (queue.isEmpty()) { // 큐가 비어있을 경우 -1 출력
                    bw.write("-1\n");
                } else { // 큐가 비어있지 않을 경우
                    bw.write(queue.pop() + "\n"); // 큐가 있는 요소 pop
                }
            } else if (command.equals("empty")) { // empty 명령시
                if (queue.isEmpty()) { // 큐가 비어있을 경우 -1 출력
                    bw.write("1\n");
                } else { // 큐가 비어있지 않을 경우 0 출력
                    bw.write("0\n");
                }
            } else {
                bw.write(queue.size() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}





