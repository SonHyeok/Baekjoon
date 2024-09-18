import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    /**
     * 올라가는 거리 A , 미끄러지는 거리 B, 나무 막대의 높이 v
     * 이미 밤에 미끄러진 후, 다음날 정상에 도착 가능한 최소 높이 구해야 함. (= V - A)
     * 하루에 A만큼 올라가고 B만큼 무조건 미끄러지기에 하루에 A - B 만큼 이동한다고 봐야함.
     * A - B 만큼 이동해서 V - A까지 걸리는 날짜를 카운트 해야 함.
     * 마지막날은 도착하는 날이기에 하루 추가해야 함.
     * 또한, 목적지에 도달한 줄 알았으나, 잔여 거리가 남는 상황이 있을 수도 있음.
     * 그러한 경우에는 나머지 연산을 통해 1일 추가해줌
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 이동 거리
        int B = Integer.parseInt(st.nextToken()); // 미끄러지는 거리
        int V = Integer.parseInt(st.nextToken()); // 목적지 높이

        int totalDay = ((V - A) / (A - B)); // 몫으로 계산한 목적지까지의 일 수 

        if ((V - A) % (A - B) != 0) { // 잔여 거리 남았는지 확인
            totalDay++;
        }
        System.out.println(totalDay + 1);
    }
}