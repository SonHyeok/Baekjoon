import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /**
     * 1 <= n <= 500,000
     * 규칙은 앞자리를 버리고, 그 다음 자리를 맨 뒤로 옮기는 것이다.
     * 앞으로만 데이터가 빠지고 뒤로 데이터가 추가되기 때문에 자료구조 큐를 사용하면 될 것 같다!*
     * 시간 복잡도는 반복문 n번만 돌면 되기 때문에 O(n) 예상
     *
     * 시간 복잡도를 줄이기 위해 추가, 삭제 연산이 많으므로 링크드 리스트를 사용한 큐를 사용한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i <= count; i++) { // N크기 배열 생성
            list.add(i);
        }

        while (list.size() != 1) {
            list.remove();

            Integer removed = list.remove();
            list.add(removed);
        }

        System.out.println(list.peek());

        br.close();
    }

}




