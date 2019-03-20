package Prep.SMaestro_problems;

import java.util.Scanner;

//잘 기억은 안난다. 논문 관련해서 해당 글자를 바꾸는 것같음 
public class problem4 {
	final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String text = sc.nextLine();
		if(text.length() > 300)
		{
			System.out.println("글자 수 초과");
			return;
		}
		else
		{
			String first = sc.next();
			String second = sc.next();
			fixtext(text, first, second);
			return;
		}
	}
	
	private static void fixtext(String text, String first, String last)
	{
		text = text.replaceAll(first, last);
		System.out.println(text);
		return;
	}
}
