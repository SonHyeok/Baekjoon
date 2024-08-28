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

        totalScore = info.stream().
                map(insideList -> Double.valueOf(insideList.get(1)) * whichGrade(insideList.get(2)))
                .mapToDouble(Double::doubleValue)
                .sum();

        totalStudyPoint = info.stream().filter(insideList -> !(insideList.get(2).equals("P")))
                .map(insideList -> Double.valueOf(insideList.get(1)))
                .mapToDouble(Double::doubleValue)
                .sum();

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
