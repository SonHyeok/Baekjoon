import java.io.*;

/**
 *  N이 늘어날수록 찾아야 하는 문자열 규칙(IOI)의 길이가 2N + 1 규칙으로 늘어난다.
 *  문자열의 길이 M보다 2N + 1만큼 작은 범위까지만 탐색을 진행해야 한다.
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 패턴 수
        int N = Integer.parseInt(br.readLine());

        // 문자열 길이
        int M = Integer.parseInt(br.readLine());

        // 입력받은 문자열
        char[] words = br.readLine().toCharArray();

        // 총 패턴 갯수
        int total = 0;

        // OI 패턴 카운트
        int count = 0;

        for (int i = 0; i < words.length - 2; i++) {

            // I로 시작할 경우
            if (words[i] == 'I') {

                // OI 패턴 발견시
                if (words[i + 1] == 'O' && words[i + 2] == 'I') {
                    // 카운트 추가
                    count++;

                    // 카운트 IOI 패턴 갯수가 N과 같을 경우
                    if (count == N) {
                        // 총 합에 추가
                        total++;

                        // 다음 탐색 지점으로 넘어가면서 OI 패턴이 하나 사라지기에 카운트에서 차감
                        // ex) IOIOI, N이 1인 경우 -> 처음 IOI 카운트 이후 겹치는 IOI로 넘어가면서 앞에 IO가 빠짐. 따라서 카운트 1 차감
                        count--;
                    }

                    // 현재 IOI인 것을 확인 했기에 2칸 건너뛰어 겹치는 IOI 있는지 확인하기 위해 여기서 i + 1, 이후 반복문에서 i + 1을 통해 총 2칸 이후 지점부터 탐색
                    i++;
                }

                // 패턴 발견하지 못했을 시 겹치는 부분이 없는 것이기에, 카운트 초기화
                else{
                    count = 0;
                }

            }
        }

        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }
}
