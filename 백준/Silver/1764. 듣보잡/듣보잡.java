import java.io.*;

import java.util.*;


/**
 * 입력 수 N,M
 * N,M <= 500,000
 * 듣도 못한사람 , 보도 못한 사람에 모두 포함되는 사람의 이름을 사전순으로 출력
 * 사전에 정렬하기 위해서 저장하면서 정렬되는 TreeSet 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (key : 번호, value: 이름)으로 저장된 map과 (key: 이름, value: 번호)로 저장된 map으로 총 2가지 생성
        Set<String> noListenSet = new TreeSet<>();
        Set<String> noMeetAndListenSet = new TreeSet<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 저장
        for (int i = 0; i <N; i++) {
            noListenSet.add(br.readLine());
        }

        // 듣도 보도 못한 사람을 저장
        for (int i = 0; i < M; i++) {
            String noMeetMan = br.readLine();

            if (noListenSet.contains(noMeetMan)) {
                noMeetAndListenSet.add(noMeetMan);
            }
        }

        // 듣도 보도 못한 사람의 숫자 먼저 bw에 작성
        bw.write(noMeetAndListenSet.size() + "\n");

        // 듣도 보도 못한 사람 명단 bw에 작성
        for (String name : noMeetAndListenSet) {
            bw.write(name + "\n");
        }

        // 시간 복잡도는 O(1) + O(M * logN) + O(1)
        // 듣도 못한 사람 저장 N, 듣도 못한 사람과 보도 못한 사람을 비교하기에 보도 못한 사람 M과 TreeSet의 contains 메소드의 시간복잡도 logN => M * logN, 이후 겹치는 사람의 숫자만큼 bw에 저장하면서 상수의 시간이 소요됨.
        bw.flush();
        bw.close();
        br.close();
    }
}
