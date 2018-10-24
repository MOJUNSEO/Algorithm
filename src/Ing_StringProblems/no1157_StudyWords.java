package Ing_StringProblems;

import java.util.Scanner;

/*
 * 4번이나 뻘짓했음.
 * 해결방법 : 1. 단어를 쪼개서 알파벳 카운트.
 * 2. 일단 가장 큰 값을 찾아서 값과 인덱스 저장(2개일수도있는 경우가 존재한다.)
 * 3. 해당 인덱스가 아니면서 동일한 값(가장 큰값) 존재하는지 찾음. 없으면 -> 이게 제일 많은거고, 있으면 -> 다중 MAX값이므로 ?출력.
 * 
 * */
public class no1157_StudyWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		Solution(str);
		sc.close();
		return;
	}
	
	static void Solution(String str)
	{
		int index[] = new int[26];
		int max = Integer.MIN_VALUE;
		int maxindex = 0;
		for(int i=0;i<str.length();i++)
		{
			index[str.charAt(i)-65]++;
		}
		
		for(int i=0;i<26;i++)
		{
			if(index[i] > max)
			{
				max = index[i];
				maxindex = i;
			}
		}
		

		for(int i=0; i<26;i++)
		{
			if(i == maxindex)
			{
				continue;
			}
			else if(i != maxindex && index[i] == max)
			{
				System.out.println("?");
				return;
			}
		}
		System.out.println((char)(maxindex+65));

		return;
	}
}
