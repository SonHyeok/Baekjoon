import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        String input = br.readLine();

        // '-' 기준으로 split
        String[] split = input.split("-");

        // 첫 번째 덩어리 처리 (항상 더하기 연산만 존재하는 경우)
        int total = sum(split[0]);

        // 이후 덩어리들은 모두 빼기로 처리
        for (int i = 1; i < split.length; i++) {
            total -= sum(split[i]); // 괄호로 묶어 빼는 효과
        }

        // 결과 출력
        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();
    }

    // 덧셈 연산자 처리 함수
    private static int sum(String expr) {
        int result = 0;
        String[] nums = expr.split("\\+"); // '+' 기준 split
        for (String num : nums) {
            result += Integer.parseInt(num); // 정수 변환 및 합산
        }
        return result;
    }
}
