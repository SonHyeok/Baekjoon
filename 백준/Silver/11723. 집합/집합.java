import java.io.*;

import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("all")) {
                set.clear();

                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (command.equals("empty")) {
                set.clear();
            }
            else{

                int num = Integer.parseInt(st.nextToken());

                if (command.equals("add")) {
                    set.add(num);
                } else if (command.equals("remove")) {
                    set.remove(num);
                } else if (command.equals("check")) {
                    if (set.contains(num)) {
                        bw.write("1\n");
                        continue;
                    }
                    bw.write("0\n");
                } else if (command.equals("toggle")) {
                    if (set.contains(num)) {
                        set.remove(num);
                        continue;
                    }
                    set.add(num);
                }
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
