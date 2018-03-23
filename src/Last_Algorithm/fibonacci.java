package Last_Algorithm;import java.util.Scanner;


public class fibonacci {
	static int zero=0;;
	static int one=0;
	public static void main(String[] args) {
		int cycle;
		Scanner sc = new Scanner(System.in);
		
		cycle = sc.nextInt();
		
		if(cycle > 40 && cycle < 0)
		{
			return;
		}		
		int arr[] = new int[cycle];
		
		for(int i=0;i<cycle;i++)
		{
			arr[i] = sc.nextInt();
		}		
		for(int i=0;i<cycle;i++)
		{
			fibonacci(arr[i]);
			System.out.println(zero + " " + one);
			zero = 0;
			one = 0;
		}
	}	
	public static int fibonacci(int n)
	{
		if(n==0)
		{
			zero++;
			return 0;
		}
		else if(n==1)
		{
			one++;
			return 1;
		}
		else
		{
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
