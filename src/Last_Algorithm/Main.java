package Last_Algorithm;import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R1 = sc.nextInt();
		int s = sc.nextInt();
		
		int R2=0;
		
		if(R1 <= -1000 || R1 >= 1000)
		{
			return;
		}
		R2 = ((s*2)-R1);
		System.out.println(R2);
		
		
	}
}
