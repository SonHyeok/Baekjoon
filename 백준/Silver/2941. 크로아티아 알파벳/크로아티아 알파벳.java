import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for (int i = 0; i < words.length(); i++) {
            for (String cro : croatiaAlphabets) {
                if (i + cro.length() <= words.length() && words.substring(i, i + cro.length()).equals(cro)) {
                    i += cro.length() - 1; // Adjust index for next character
                    break;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
