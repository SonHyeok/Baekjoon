import java.io.*;

import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;

            switch(command) {
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
                default:
                    num = Integer.parseInt(st.nextToken());
                    switch (command){
                        case "add" :
                            set |= 1 << num;
                            break;
                        case "remove":
                            set &= ~(1 << num);
                            break;
                        case "check":
                            if ((set & (1 << num)) != 0) {
                                bw.write("1\n");
                            } else {
                                bw.write("0\n");
                            }
                            break;
                        case "toggle":
                            set ^= 1 << num;
                            break;
                    }

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
