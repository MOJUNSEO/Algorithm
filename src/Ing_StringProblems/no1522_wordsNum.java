package Ing_StringProblems;

import java.util.Scanner;

public class no1522_wordsNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 신셰계;;;;;; trim -> 앞 뒤공백 제거;;; 괜히 뻘짓함  */
		/* trim을 직접 코드로 작성해서 9번이나 런.타.임.에.러.남. */
		String input = sc.nextLine().trim();
		sc.close();
		Solution(input);
	
	}
	
	static void Solution(String str)
	{
		if(str.isEmpty())
		{
			System.out.println("0");
		}
		else
		{
			System.out.println(str.split(" ").length);
		}
		return;
	}
}
	
	