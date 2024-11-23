import java.io.*;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (key : 번호, value: 이름)으로 저장된 map과 (key: 이름, value: 번호)로 저장된 map으로 총 2가지 생성
        Map<Integer, String> intMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        // 입력받을 수 와 맞춰야 하는 문제 수
        int count = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= count; i++) {
            String name = br.readLine();

            intMap.put(i, name);
            stringMap.put(name, i);
        }

        for (int i = 0; i < goal; i++) {
            // key가 숫자를 포함하는지 안하는지 확인 필요
            String value = br.readLine();

            // value값이 숫자로 이루어진 경우
            if(value.matches("[0-9]+")){
                bw.write(intMap.get(Integer.parseInt(value)) + "\n");
                continue;
            }

            // value 값이 문자열일 경우
            bw.write(stringMap.get(value) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
