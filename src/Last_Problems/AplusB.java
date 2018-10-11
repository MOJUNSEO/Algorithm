package Last_Problems;

import java.util.Scanner;


public class AplusB {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		if(A <= 0)
		{
			return;
		}
		int B = sc.nextInt();
		if(B >= 10)
		{
			return;
		}
		System.out.println(A-(B));
	}
}
