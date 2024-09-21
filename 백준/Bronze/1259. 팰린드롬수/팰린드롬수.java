import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    /**
     * 맨 앞에 0나오면 패스
     * 데이터를 배열에 저장 후 하나씩 꺼내서 진행
     * 1차원 문자형 배열에 저장
     * 글자 수가 홀수, 짝수인 경우 나눠서 해야될듯
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        List<String> words = new ArrayList<>();

        // 단어 배열에 저장
        while (true) {
            String word = br.readLine();
            if (word.equals("0")) {
                break;
            }
            else{
                words.add(word);
            }
        }

        // 각 단어를 꺼내서 역순과 비교
        for (String w : words) {
            String[] reverseWord = w.split(""); // 단어를 역순으로 비교하기 위해 쪼개서 배열에 저장
            sb = new StringBuilder(); // 스트링 빌더 초기화

            for (int i = reverseWord.length - 1; i >= 0 ; i--) { // 역순으로 sb에 저장
                sb.append(reverseWord[i]);
            }

            if (sb.toString().equals(w)) { // 역순과 같은지 비교
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
