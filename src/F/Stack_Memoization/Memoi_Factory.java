package F.Stack_Memoization;

import java.util.Scanner;

public class Memoi_Factory {
	static int result = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		
		factorial(limit);
		
		sc.close();
		System.out.println(result);
		return;
		
	}
	
	private static void factorial(int x)
	{
		if(x > 1)
		{
			factorial(x-1);
		}
		
		result = result*x;
		return;
	}
}
