import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String word = br.readLine();
            boolean flag = true;

            if(word.equals("0")) break;

            char[] chars = word.toCharArray();

            for(int i = 0; i < chars.length / 2; i++){
                if (chars[i] != chars[chars.length - 1 - i]) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }

        }

        bw.flush();
    }
}
