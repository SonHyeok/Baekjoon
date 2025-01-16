import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);

        String temp = A + B;

        bw.write((a + b - c) + "\n");
        bw.write(String.valueOf(Integer.parseInt(temp) - c));

        bw.flush();
        bw.close();
        br.close();


    }


}
