import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * StringBuilder를 사용해서 성능 개선
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());

        StringBuilder[] sb = new StringBuilder[201];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        
        for (int i = 0; i < count; i++) { // counting Sort 사용
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());

            sb[age].append(age).append(" ").append(st.nextToken()).append("\n"); // 나이에 해당하는 인덱스에 이름 입력, 순서대로 입력되므로 나이가 같아도 알아서 정렬되어 있는 구조
        }

        for (StringBuilder stringBuilder : sb) {
            bw.write(stringBuilder.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

}