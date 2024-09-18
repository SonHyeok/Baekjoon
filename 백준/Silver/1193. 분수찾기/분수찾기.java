import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    /**
     * 대각 칸의 개수에 대한 규칙 찾기 or 각 칸의 합이 대각선마다 같은 규칙 찾기
     * 9 입력
     * total = 10, level = 4, findNum = 9
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int findNum = Integer.parseInt(br.readLine());

        int total = 0;
        int level = 1; // 증가하는 칸의 개수

        while (true) { // 칸의 개수만큼 더하다가 목표 칸수보다 커지면 멈춤
            total += level;

            if(total >= findNum){

                // 대각 칸의 개수 짝수 기준
                int top = findNum - (total - level); // 분자
                int bottom = (level + 1) - top; // 분모
                
                if (level % 2 == 0) { // 대각 칸 개수 짝수인 경우
                    System.out.println(top + "/" + bottom);
                    break;
                }else{ // 대각 칸 개수 홀수인 경우
                    System.out.println(bottom + "/" + top);
                    break;
                }
            }else{
                level++;
            }
        }
    }
}
