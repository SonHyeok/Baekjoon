import java.io.*;
import java.util.StringTokenizer;

/**
 * 이분 탐색을 통해  Upper-bound 방식으로 값을 찾아나간다.
 * 가장 큰 나무의 길이의 절반 길이부터 이분 탐색을 시작한다.
 * 결과 값이 원하는 나무의 길이보다 클 경우 현 위치와 가장 높은 위치의 중간 값으로 다시 진행하고, 이 과정을 반복한다.
 * 시간 복잡도는 O(N) + O(K * N)으로 N의 시간 내로 끝난다.
 */
public class Main {

    static int[] trees;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최대, 최소, 중간 값
        int max = 0;
        int min = 0;
        int mid = 0;

        // 나무 갯수
        int treeCount = Integer.parseInt(st.nextToken());

        // 목표 나무 길이
        int treeLength = Integer.parseInt(st.nextToken());

        trees = new int[treeCount];

        // 각 나무 길이 입력
        st = new StringTokenizer(br.readLine(), " ");

        // 나무 배열 생성
        for (int i = 0; i < treeCount; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if(trees[i] > max){
                max = trees[i];
            }
        }

        int result = 0;

        while (min <= max) {

            // 중간 값 계산
            mid = (max + min) / 2;

            // 잘린 나무 길이 총합, 매 계산마다 초기화
            long total = 0;

            // 나무를 잘라서 잘린 나무의 길이를 총합 계산
            total = getTotal(mid, total);

            // 잘린 나무의 길이가 원하는 길이보다 짧을 경우
            if (total < treeLength) {
                max = mid - 1;
            }

            // 잘린 나무의 길이가 원하는 길이보다 길 경우
            else{
                // result에 mid를 저장하는 이유는 목표 길이를 만족 하면서도 절단 높이가 가능한 최대가 되는 값을 찾는 것이다.
                // 따라서 현재 절단 높이 mid가 당장은 최대는 아니지만 목표 길이를 만족하는 유효한 절단 높이이기에 저장해 두는 것이다.
                result = mid;
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(result));


        bw.flush();
        bw.close();
        br.close();
    }

    private static long getTotal(int mid, long total) {
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] >= mid) {
                total += trees[i] - mid;
            }
        }
        return total;
    }
}
