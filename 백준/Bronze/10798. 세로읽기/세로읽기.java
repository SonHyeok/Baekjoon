import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxLength = 0;
        String[][] words = new String[5][15];
        String[] splitWords;


        for (int i = 0; i < words.length; i++) {
            splitWords = br.readLine().split("");
            for (int j = 0; j < splitWords.length; j++) {
                words[i][j] = splitWords[j];
            }
        }

        for (int i = 0; i < words.length; i++) { // 가장 긴 배열 찾기
            if(maxLength< words[i].length) {
                maxLength = words[i].length;
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < words.length; j++) {
                String word = words[j][i];
                if(word != null) {
                    System.out.print(word);
                }
            }
        }

    }
}

