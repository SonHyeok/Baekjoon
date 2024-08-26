import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt((bf.readLine()));
        int total = 0;

        for (int i = 0; i < count; i++) {
            String word = bf.readLine();

            if (checkGroupWord(word)) {
                total++;
            }
        }
        System.out.println(total);
    }

    private static boolean checkGroupWord(String word) {
        boolean[] alphabet = new boolean[26];

        char prev = word.charAt(0); // 첫 번째 문자를 이전 문자로 설정
        alphabet[prev - 'a'] = true; // 첫 번째 문자를 본 것으로 표시

        for (int j = 1; j < word.length(); j++) {
            char now = word.charAt(j);

            if (prev == now) { // 비교 값이 같은 경우
                continue;
            } else {
                if (alphabet[now - 'a']) { // 이미 이전에 도출이 된 경우 => 그룹 단어가 아님
                    return false;
                } else { // 이전에 도출된 단어가 아닌 경우 새롭게 본 문자로 표시
                    alphabet[now - 'a'] = true;
                }
            }
            prev = now; // 현재 문자를 이전 문자로 변경시킴
        }
        return true; // 그룹 단어로 확인되면 true 반환
    }
}




