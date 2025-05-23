import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = Arrays.stream(br.readLine().split(""))
            .map(Integer::parseInt)
            .sorted((n1,n2) -> n2 - n1)
            .collect(Collectors.toList());

        for(int i : list){
            bw.write(String.valueOf(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
