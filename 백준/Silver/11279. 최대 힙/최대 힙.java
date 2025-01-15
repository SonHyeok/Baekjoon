import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());

            if (queue.isEmpty() && num == 0) {
                bw.write(0 + "\n");
                continue;
            } else if (num == 0) {
                bw.write(queue.poll() + "\n");
                continue;
            }

            queue.offer(num);

        }

        bw.flush();
        bw.close();
        br.close();


    }


}
