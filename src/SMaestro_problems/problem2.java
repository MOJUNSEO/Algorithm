package SMaestro_problems;

import java.util.Scanner;

// 홈페이지 확인 
// 알파벳 , 숫자 , 특수문자 
public class problem2 {
	final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String id = sc.next();
		String pw1 = sc.next();
		String pw2 = sc.next();
		
		if(id.length() < 3 || id.length() > 20)
		{
			System.out.println("아이디 조건 오류 : " + "fail");
			return;
		}
		if(pw1.equals(pw2))
		{
			if(checkNumber(pw1) && checkAlpha(pw1) && checkSymbol(pw1))
			{
				System.out.println("success");
			}
			else
			{
				System.out.println("숫자, 알파벳, 특수문자 미포함 오류 : " + "fail");
			}
		}
		else
		{
			System.out.println("비밀번호 불일치 오류 : " + "fail");
			return;
		}
	}
	private static boolean checkNumber(String inputString)
	{
		int inputlength = inputString.length();
		String[] inputArr = inputString.split("");
		
		//init
		String[] Numbers = new String[10];
		for(int i = 0 ; i < 10; i++)
		{
			Numbers[i] = String.valueOf(i);
		}
		
		for(int i = 0; i < inputlength; i++)
		{
			String first = inputArr[i];
			for(int j = 0; j < Numbers.length; j++)
			{
				//하나라도 있기만하면 더 이상 수행할 필요 없음 
				if(first.equals(Numbers[j]))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean checkAlpha(String inputString)
	{
		int inputlength = inputString.length();
		String[] inputArr = inputString.split("");
		
		//init
		String[] BAlphabets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] SAlphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		for(int i = 0; i < inputlength; i++)
		{
			String first = inputArr[i];
			for(int j = 0; j < SAlphabets.length; j++)
			{
				if(first.equals(SAlphabets[j]))
				{
					return true;
				}
				else if(first.equals(BAlphabets[j]))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean checkSymbol(String inputString)
	{
		int inputlength = inputString.length();
		String[] inputArr = inputString.split("");
		
		//init
		String[] Symbols = {"!","@","#","$","%","^","&","*","(",")","_","-","=","+","`","~",",","<",".",">","/","?","\\","|"};
		
		for(int i = 0; i < inputlength; i++)
		{
			String first = inputArr[i];
			for(int j = 0; j < Symbols.length; j++)
			{
				if(first.equals(Symbols[j]))
				{
					return true;
				}
			}
		}
		return false;
	}
}
