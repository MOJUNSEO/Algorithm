package Prep.SMaestro_problems;

import java.util.*;

// 글자의 가운데를 기준으로 대칭인지 확인하는 프로그램 
public class problem1 {
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++)
		{
			testcase();
		}
	}
	
	private static void testcase()
	{
		String word = sc.next();
		int wordlength = word.length();
		
		//글자수가 짝 수 일 때
		if(wordlength%2 == 0)
		{
			for(int i = 0; i < wordlength/2; i++)
			{
				char first = word.charAt(i);
				char last = word.charAt(wordlength-1-i);
				if(first != last)
				{
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		}
		//홀 수 일 때 
		else
		{
			for(int i = 0; i < wordlength/2; i++)
			{
				char first = word.charAt(i);
				char last = word.charAt(wordlength-1-i);
				if(first != last)
				{
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		}
	}
}
