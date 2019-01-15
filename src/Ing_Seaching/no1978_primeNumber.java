package Ing_Seaching;

import java.util.Scanner;

public class no1978_primeNumber {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int Count = 0;
		int Cycle = sc.nextInt();
		
		if(Cycle < 1 || Cycle > 100)
		{
			return;
		}
		
		for(int i=0; i<Cycle; i++)
		{
			int value= sc.nextInt();
			int depth = 0;
			
			if(value > 1000)
			{
				return;
			}
			
			if(value > 1)
			{
				for(int j=1;j<=value;j++)
				{
					if(value%j == 0)
					{
						depth++;
					}
				}
				if(depth == 2)
				{
					Count++;
				}
				else
				{
					continue;
				}
			}
		}
		
		System.out.println(Count);
		sc.close();
		return;
	}
}
