package Ing_StringProblems;

import java.util.Scanner;

public class no1316_GroupWordchecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Cycle = 0; 
		int Count = 0;
		
		String getCycle = sc.nextLine();
		Cycle = Integer.parseInt(getCycle);
		
		for(int i=0;i<Cycle;i++)
		{
			String word = sc.nextLine();
			if(Solution(word) == true)
			{
				Count++;
			}
		}
		sc.close();
	}
	
	static boolean Solution(String str)
	{
		if(!str.isEmpty())
		{
			//여기에 이제 코딩 
			return true;
		}
		return false;
	}
}
