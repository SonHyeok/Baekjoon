import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {    
	/**
     * 벌집의 개수가 6개씩 증가함.
     * 벌집이 커진 수보다 1번 더 이동해야 도착 가능
     * 2 ~ 7, 8 ~ 19, 20 ~ 37
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0; // 이동 카운트 수
        int range = 2; // 증가한 범위

        if (n == 1) {
            System.out.println(1);
        }else {
            while (range <= n) { // 처음 조건문이 돌아갈 때의 조건도 잘 확인할 것. (ex: range < n으로 설정하면 n이 2인경우가 false로 넘어감)
                range = range + (6 * count);
                count++;
            }
            System.out.println(count + 1); // 시작 지점 추가해서 + 1
        }

    }
}


// 아래와 같은 풀이 방법도 있으나, 메모리 성능 이슈가 있기는 하다..
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        List<List<Integer>> li = new ArrayList<>();
//
//        int startPoint = 1;
//        int endPoint = 0;
//        int level = 2; // 이동한 위치의 숫자
//
//        for (int i = 1; i <= n; i++) {
//            List<Integer> inners = new ArrayList<>(); // inners.clear 사용시 이미 li에 add됐던 데이터까지 삭제되는 문제때문에 객체 새로 생성
//
//            for (int j = level; j < level + (6 * i); j++) {
//                inners.add(j);
//            }
//            li.add(inners);
//
//            // 입력수보다 level이 작으면 다음 라운드 실행
//            if (level < n) {
//                level += 6 * i;
//            }else{  // 입력수보다 level이 커지면 종료
//                break;
//            }
//        }
//
//        for (int i = 0; i < li.size(); i++) {
//            if (li.get(i).contains(n)) {
//                endPoint = startPoint + (i + 1);
//            }
//        }
//
//        System.out.println(endPoint);
