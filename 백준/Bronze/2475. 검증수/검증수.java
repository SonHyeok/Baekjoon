import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] list = br.readLine().split(" ");

        int total = 0;

        for (String s : list) {
            int num = Integer.parseInt(s);
            total += (num * num);
        }

        bw.write(String.valueOf(total % 10));


        bw.flush();
        bw.close();
        br.close();
    }


}
