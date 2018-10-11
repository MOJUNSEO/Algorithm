package Ing_StringProblems;
import java.util.Scanner;

public class no2908_constant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int Result = Solution(A,B);
		System.out.println(Result);
		sc.close();
	}
	
	static int Solution(int A, int B)
	{		
		String Astring[] = String.valueOf(A).split("");
		String Bstring[] = String.valueOf(B).split("");
		
		String Aresult = "";
		for(int i=Astring.length-1;i>=0;i--)
		{
			Aresult += Astring[i];
		}
		int Aint = Integer.parseInt(Aresult);
		String Bresult = "";
		for(int j=Bstring.length-1;j>=0;j--)
		{
			Bresult += Bstring[j];
		}
		int Bint = Integer.parseInt(Bresult);
		
		
		
		return Math.max(Aint, Bint);
	}
}
