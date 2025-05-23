import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 3; i++) strings.add(st.nextToken());

        List<Integer> list = strings.stream().map(Integer::parseInt).sorted()
            .collect(Collectors.toList());

        bw.write(String.valueOf(list.get(1)));

        bw.flush();
        bw.close();
        br.close();
    }

}
