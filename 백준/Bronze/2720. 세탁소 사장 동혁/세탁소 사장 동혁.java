import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<List<Integer>> coin_list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int changeMoney = Integer.parseInt(br.readLine());
            List<Integer> coins = new ArrayList<>();

            coins.add(changeMoney / 25);
            changeMoney = changeMoney % 25;

            coins.add(changeMoney / 10);
            changeMoney = changeMoney % 10;

            coins.add(changeMoney / 5);
            changeMoney = changeMoney % 5;

            coins.add(changeMoney);

            coin_list.add(coins);
        }

        for (List<Integer> integers : coin_list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

