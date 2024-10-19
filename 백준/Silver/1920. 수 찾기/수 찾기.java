import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1 <= N,M <= 100,000
     *  배열 A,B는 각각 N과 M의 크기를 따라감
     *  최악의 경우 100,000개의 데이터에 대해 100,000번 비교해서 데이터를 찾아야 하는 경우가 발생 => O(N^2)
     *  정수의 범위는 int형의 범위와 같은 => 4byte == 32bit

     *  시간 복잡도를 줄이기 위해서 내가 생각한 방안
     *  boolean 배열을 사용 -> 한 번 찾은 수는 true로 설정해서 다음에 같은 수가 나와도 다시 찾지 않도록 memoization 진행
     *  B배열을 만든 크기만큼 boolean 배열을 생성해서 숫자와 맞는 자리에는 true를 넣어놓는다.
     *  이후 배열 인덱스로 찾아가면 시간 복잡도가 O(1)이기에 비교한다.
     */
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }

        count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            if(set.contains(Integer.valueOf(st.nextToken()))){
                bw.write(1 + "\n");
            }else{
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        bw.close(); br.close();
    }
}