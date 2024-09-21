import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		double arr[] = new double[N];
		double min,max;
		double result = 0.0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = s.nextDouble();	
		}
		min = arr[0];
		max = arr[0];
		
		for(int i = 0; i < N; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			else if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < N; i++) {
			arr[i] = arr[i] / max * 100;
			result += arr[i];
		}
		result /= (double)(arr.length);
		
		System.out.println(result);
		s.close();
	}

}
