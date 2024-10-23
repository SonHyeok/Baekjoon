import java.io.*;

public class Main {

    /**
     * 3 <= n <= 5000
     * 먼저 5로 나눈 나머지에 3으로 나눈 나머지가 0이 아닌경우 -1 출력, 그 반대의 경우도 -1 출력
     * <p>
     * 3킬로 짜리만으로 나눴을 때 개수와, 5킬로 짜리만으로 나눴을 때 갯수, 3킬로와 5킬로 짜리로 함께 나눴을 때 개수를 모두 비교 필요
     * 먼저 5로 나누어지지 않으면 3킬로 포대 하나를 추가한다.
     * 그렇게 반복하다가 5로 나누어지면 5키로 포대 하나를 추가한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int total = 0;

        while (count > 0) {

           
            if (count % 5 == 0) {
                total += count / 5;
                break;
            }else{
                count -= 3;
                total++;
            }

   
            if (count < 0) {
                total = -1;
            }

        }

        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }



}





