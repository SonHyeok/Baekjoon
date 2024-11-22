import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

 
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] nums = {a, b, c};

            Arrays.sort(nums);

            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                break;
            }

            if ((Math.pow(nums[0],2)) + (Math.pow(nums[1],2)) == (Math.pow(nums[2],2))) {
                bw.write("right\n");
            }else{
                bw.write("wrong\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
