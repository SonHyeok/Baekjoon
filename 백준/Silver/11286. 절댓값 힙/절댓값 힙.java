import java.io.*;
import java.util.PriorityQueue;

/**
 *  최소 힙을 사용하여 절댓값 비교를 통해 작은 값을 루트쪽에 놓고, 절댓값으로 비교시 동일한 절댓값이 있을 경우 음수인 값을 더 위에 놓는다.
 *  노드에 값과 부호(+ or -)를 함께 넣어서 힙에 넣을지, 절댓값 비교 후 같은 값일시 음수 양수 비교를해서 넣을지 고안해야함
 *
 * 시간 복잡도는 최대 100,000인 N에 대해서 반복하는 것이기에 최대 100,000번의 연산 실행
 * 따라서 O(N)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 절댓값이 같은 경우
            if(abs1 == abs2){
                // 절댓값이 아닌 원래의 값으로 비교
                return o1 - o2;
            }
            // 절댓값이 다른 경우 절댓값으로 비교
            else{
                return abs1 - abs2;
            }
        });

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());

            // 입력 수가 0이 아닌 경우 우선순위 큐에 추가
            if (num != 0) {
                priorityQueue.offer(num);
            }
            // 입력 수가 0인 경우 큐의 비어있는지 여부를 확인해서 로직 실행
            else {
                if (priorityQueue.isEmpty()) {
                    bw.write(0 + "\n");
                }else{
                    bw.write(priorityQueue.poll() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
