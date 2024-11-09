import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1 <= M <= N <= 1,000,000
     * M부터 N까지 하나 이상의 소수가 있어야 하는 입력 조건
     * M부터 N까지의 자연수 중에서
     * M부터 루트 N 이하까지 반복하면서 M을 제외하고 M의 배수들을 제외시킨다.
     * M부터 루트 N까지 반복하면서  logn의 시간 소요, 반복수 i를 두고 2부터 i까지 1씩 증가하면서 약수가 존재하는지 확인하는데 n의 시간 소요
     * 총 O(logN * N)의 시간 소요
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1];
        
        getPrime(prime, N);

        // M부터 N까지 소수 출력
        for (int i = M; i < prime.length; i++) {
            if (!prime[i]) {

                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close(); br.close();
    }

    // 소수 배열 구하기
    private static void getPrime(boolean[] prime,int N) {
        prime[0] = prime[1] = true; // 0과 1은 소수가 아님

        // 2부터 N의 제곱근까지 i의 배수 필터 적용
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) {
                continue;
            }

            // 2,3같은 소수들이 필터에 걸러지면 안되기에 시작 수를 i * i로 설정
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}

