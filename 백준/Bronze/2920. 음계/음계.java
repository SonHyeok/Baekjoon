import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = st.countTokens();

        int startNum = Integer.parseInt(st.nextToken());
        boolean flag = false;

        if (startNum == 1) {
            for (int i = startNum + 1; i <= count ; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (num != i) {
                    bw.write("mixed");
                    flag = true;
                    break;
                }
            }

            if(!flag){
                bw.write("ascending");
            }

        } else if (startNum == 8) {
            for (int i = startNum - 1; i >= 1; i--) {
                int num = Integer.parseInt(st.nextToken());

                if (num != i) {
                    bw.write("mixed");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                bw.write("descending");
            }
        }else {
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();


    }


}
