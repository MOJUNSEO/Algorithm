package F.Stack_Memoization;

import java.util.Scanner;

public class Memoi_Fibonachi {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i=1;i<=input;i++)
		{
			System.out.println(fibonachi(i));
		}
		
		sc.close();
		return;
		
	}
	
	private static int fibonachi(int x)
	{
		if(x <= 1)
		{			
			return x;
		}
		else
		{
			return fibonachi(x-1) + fibonachi(x-2);
		}
	}
}
