import java.io.*;


public class Main {

    /**
     * 입력이 Fizz, Buzz, FizzBuzz 인 경우는 continue
     * 숫자인 경우는 변수에 담아서 1씩 올리는 방법 채택
     * 1 올린 수가 조건에 맞는지 검사 후 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;

        for (int i = 0; i < 3; i++) {
            String word = bf.readLine();
            if (word.equals("Fizz") || word.equals("Buzz") || word.equals("FizzBuzz")) { // 3개의 문자열 중에서 지정한 문자가 입력되었다면,
                if (num != 0) { // 지정 문자가 입력되었는데, 이전에 숫자가 나와서 변수에 할당이 되었다면,지정 문자가 입력된 칸에 대해서 1 증가
                    num++;
                }
            }
            else { // 숫자가 입력되었다면
                if (num == 0) {
                    num = Integer.parseInt(word); // 해당 숫자를 변수에 저장후 1 증가
                    num++;
                }else {
                    num++;
                }
            }
        }


        // 이후 조건문 수행하여 결과 출력
        if (num == 0) {
            bw.write("FizzBuzz");
        } else if (num % 3 == 0 && num % 5 == 0) {
            bw.write("FizzBuzz");
        } else if (num % 5 != 0 && num % 3 == 0) {
            bw.write("Fizz");
        } else if (num % 3 != 0 && num % 5 == 0) {
            bw.write("Buzz");
        }else {
            bw.write(Integer.toString(num));
        }

        bw.flush();
        bw.close();
        bf.close();
    }
}




