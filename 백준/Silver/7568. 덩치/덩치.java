import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 처음에는 정렬을 해서 등수를 매길까 함,
     * 해당 방법으로 진행하려 했으나 1시간 이상 고민해도 답을 찾ㅈ지 못해 해설 참조
     * 2중 반복문으로 한명씩 모두 비교해서 rank를 찾는 방법 도입
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[][] list = new int[count][2];

        // 키/몸무게 입력
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] n : list) {
            int rank = 1;

            for (int[] k : list) {
                if (n[0] > k[0] && n[1] > k[1]) { // 덩치 큼
                    continue;
                } else if ((n[0] >= k[0] && n[1] <= k[1]) || (n[0] <= k[0] && n[1] >= k[1])) { // 같은 덩치
                    continue;
                }else { // 덩치 작음
                    rank++;
                }
            }

            bw.write(rank + " ");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}