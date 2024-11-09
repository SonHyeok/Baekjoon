import java.io.*;
import java.util.*;

/**
 * 테스트 케이스의 갯수 K
 * 문서의 갯수 T (1 <= T <= 100), 몇번째로 인쇄되었는지 궁금한 문서의 현재 위치 M(0 ≤ M < T)
 * 원소 하나를 뽑고, 뒤에 원소들과 비교한다. 그러다가 첫 원소보다 큰 원소가 존재하면 해당 큰 원소 앞에  작은 원소들은 모두 뒤로 보낸다
 */
public class Main {

// 2 4 1 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine()); // 테스트 케이스 갯수

        for (int i = 0; i < T; i++) {
            LinkedList<Integer[]> queue = new LinkedList<>(); //큐로 사용할 연결 리스트 생성

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 갯수
            int M = Integer.parseInt(st.nextToken()); // 인쇄 순서가 궁금한 문서의 위치

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // N의 크기만큼 연결리스트에 원소 추가
                queue.offer(new Integer[] {j , Integer.valueOf(st.nextToken())}); // {인덱스, 중요도} 배열로 들어감
            }

            // 몇번째로 출력되는지 카운트하는 변수
            int count = 0;

            while (!queue.isEmpty()) {
                Integer[] front = queue.poll(); // 가장 첫번째 원소 poll
                boolean isMax = true; // front 원소가 가장 큰 수인지 판별

                // 큐에 남아있는 원소들과 중요도 비교
                for (int j = 0; j < queue.size(); j++) {

                    // 첫 원소의 중요도보다 i번째 원소의 중요도가 더 큰 경우
                    if (front[1] < queue.get(j)[1]) {

                        // j번째 원소의 중요도보다 앞에있는 중요도가 낮은 원소들을 뒤로 보냄
                        queue.offer(front);
                        for (int k = 0; k < j; k++) {
                            queue.offer(queue.poll());
                        }

                        // 가장 큰 중요도가 아니기에 false로 변경 후 반복문 탈출
                        isMax = false;
                        break;
                    }
                }

                // 가장 큰 중요도가 아니면 반복문 다시 진행
                if (!isMax) {
                    continue;
                }

                // 가장 큰 중요도일 경우 출력해야 하므로 count + 1
                count++;
                if (front[0] == M) { // 몇번째로 인쇄되는지 궁금한 문서의 위치가 맞을 경우
                    break;
                }

            }
            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}




