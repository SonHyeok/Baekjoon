import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "front" :
                    bw.write(front() + "\n");
                    break;
                case "back" :
                    bw.write(back() + "\n");
                    break;
                case "size" :
                    bw.write(size() + "\n");
                    break;
                case "empty" :
                    bw.write(empty() + "\n");
                    break;
                case "pop" :
                    bw.write(pop() + "\n");
                    break;
            }

        }

        bw.flush();

    }

    public static void push(int n) {
        queue.offer(n);
    }

    public static int pop() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.poll();
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static int front(){
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.getFirst();
    }

    public static int back() {
        if(queue.isEmpty()){
            return -1;
        }

        return queue.getLast();
    }
}
