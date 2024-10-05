import java.io.*;
import java.util.Arrays;

public class Main {

    /**
     * 길이 비교 후, 같은 길이일 경우 char 형으로 단어의 아스키 코드 비교
     * 출력 시 비교할 경우 최악의 상황 O(N^2)
     * Comparator Or Comparable 활용
     */


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] list = new String[count];

        for (int i = 0; i < list.length; i++) {
            list[i] = br.readLine();
        }
        
        Arrays.sort(list, (w1, w2) -> { // Comparator 메소드 람다함수로 제공
                        if (w1.length() == w2.length()) {
                            return w1.compareTo(w2);
                        }else{
                            return w1.length() - w2.length();
                        }
                    });
        
        
        bw.write(list[0] + "\n"); // 첫번째 단어 추가
        for (int i = 1; i < list.length; i++) { // 중복 제거 하면서 bw에 저장
            if (!list[i].equals(list[i - 1])) {
                bw.write(list[i] + "\n");
            }
        }

        bw.flush();
        bw.close(); br.close();
    }

}




