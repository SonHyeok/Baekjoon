import java.io.*;
import java.util.*;


// (학점 * 성적)의 총합을 학점 총합으로 나눈 것이 전공 평점
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double totalScore;
        double totalStudyPoint;
        List<List<String>> info = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            info.add(Arrays.asList(bf.readLine().split(" ")));
        }

        // 학점 * 성적의 합계 구하기
        totalScore = info.stream().
                map(insideList -> Double.valueOf(insideList.get(1)) * whichGrade(insideList.get(2))) // 학점 * 성적 연산
                .mapToDouble(Double::doubleValue) // 연산 결과 리스트를 DoubleStream 형태로 변환
                .sum(); // 총합 구하기

        // 학점 총합 구하기
        totalStudyPoint = info.stream().filter(insideList -> !(insideList.get(2).equals("P"))) // 필터를 사용해 과목 점수가 P인 과목은 제외
                .map(insideList -> Double.valueOf(insideList.get(1))) // P가 제외된 과목의 학점들 수집
                .mapToDouble(Double::doubleValue) // 해당 학점들 Double Stream으로 변환
                .sum(); // 총합 구하기

        System.out.printf("%.6f",(totalScore / totalStudyPoint));
    }

    public static double whichGrade(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "P":
                return 0.0;
        }
        return 0.0;
    }
}
