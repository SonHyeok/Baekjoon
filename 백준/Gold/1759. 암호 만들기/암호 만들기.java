import java.io.*;
import java.util.*;

/**
 * 모음 1개인 경우와 모음이 2개인 경우 나눠서 구해야 함
 *
 */
public class Main {

    static int length, wordCount;
    static char[] words, code;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 암호 길이
        length = Integer.parseInt(st.nextToken());

        // 문자 갯수
        wordCount = Integer.parseInt(st.nextToken());

        // 문자 저장 배열
        words = new char[wordCount];
        code = new char[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < wordCount; i++){
            words[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(words);

        makePassword(0,0);


        bw.flush();
        bw.close();
        br.close();
    }

    // a c i s t w
    static void makePassword(int depth, int start) throws IOException {
        if (depth == length) {
            if(isValid(code)){
                for (char c : code) {
                    bw.write(c);
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = start; i < wordCount; i++) {
            code[depth] = words[i];
            makePassword(depth + 1, i + 1);
        }
    }

    static boolean isValid(char[] code) {
        int c = 0; // 자음
        int v = 0; // 모음

        for (char word : code) {
            if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u') {
                v++;
            }
            else{
                c++;
            }
        }

        if (v >= 1 && c >= 2) {
            return true;
        }

        return false;
    }
}

