import java.io.*;
import java.util.*;

/**
 * https://st-lab.tistory.com/145 해당 풀이 참고
 * 해당 문제는 "활동 선택 문제"라고 칭함
 * 간단히, 한 사람이 하나의 활동(ex: 회의 참석)에 대해서만 작업 가능할 때, 최대한 많은 활동을 할 수 있는 수를 선택하는 문제.
 * 또한 문제의 조건은 하나의 활동을 환료하기 전까지 다른 활동 선택이 불가함.
 * 즉, 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이고, 탐욕 선택이 이후의 결과에 영향을 미치지 않음.
 * 
 * 서로 겹치지 않는 활동에 대해, 종료 시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아짐
 * 종료 시간을 기준으로 정렬할 것.
 * 이후 종료 시간이 겹치지 않는 작업 순서대로 선정 후, 해당 작업들 중에 다음 회의 시작 시간이 이전 회의 종료 시간과 겹치지 않도록 필터링 필요
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());


        int[][] time = new int[count][2];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 시작 시간, 종료 시간 설정
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());

        }

        // 종료 시간 기준으로 정렬
        Arrays.sort(time, (o1, o2) -> {
            // 종료 시간이 같을 경우 시작 시간 기준으로 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });


        int result = 0;
        int preEndTime = 0;

        for (int i = 0; i < count; i++) {

            // 이전에 끝난 회의 시간이 다음 시작할 회의 시간보다 빠르거나 같은 경우
            if (preEndTime <= time[i][0]) {
                // 다음 회의 끝나는 시간으로 변수 값 변경
                preEndTime = time[i][1];
                // 회의 갯수 추가
                result++;
            }
        }


        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
