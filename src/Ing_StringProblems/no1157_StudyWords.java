package Ing_StringProblems;

import java.util.Scanner;

public class no1157_StudyWords {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		Solution(word);
	}
	
	
	static void Solution(String str)
	{
		String boxarr[] = str.toUpperCase().split("");
		int resultarr[] = new int[boxarr.length];
		for(int i=0; i< resultarr.length; i++)
		{
			resultarr[i] = 1;
		}
		
		for(int i=0; i<boxarr.length;i++)
		{
			for(int j=i+1;j<boxarr.length;j++)
			{
				if(resultarr[j] != -1)
				{
					if(boxarr[i].equals(boxarr[j]))
					{
						resultarr[i]++;
						resultarr[j] = -1;
					}
				}
			}
		}
		
		int max = 0;
		int maxindex = 0;
		for(int i=0;i<resultarr.length;i++)
		{
			if(resultarr[i] > max)
			{
				max = resultarr[i];
				maxindex = i;
			}
		}
		
		for(int i=0;i<resultarr.length;i++)
		{
			if(i != maxindex)
			{
				if(resultarr[maxindex] == resultarr[i])
				{
					System.out.println("?");
					return;
				}
			}
			
		}
		
		System.out.println(boxarr[maxindex]);
		return;
	}
}
