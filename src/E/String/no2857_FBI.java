package E.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class no2857_FBI {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String inputName = null;
		String result = "";
		for(int i=0; i<5; i++)
		{
			inputName = sc.nextLine();
			if(i != 4 && __Solution(inputName)==true)
			{
				result += String.valueOf(i+1) + " ";
			}
			else if(i == 4 && __Solution(inputName)==true)
			{
				result += String.valueOf(i+1);
			}
		}
		if(result=="" || result.equals(""))
		{
			System.out.println("HE GOT AWAY!");
		}
		else
		{
			System.out.println(result);
		}
		sc.close();
		return;
		
	}
	
	/* 특정 문자열을 찾는데 3가지 방법이 존재  */
	private static boolean __Solution(String codeName)
	{
//		Pattern p = Pattern.compile("FBI");
//		Matcher m = p.matcher(codeName);
//		if(m.find())
//		{
//			return true;
//		}
//		if(codeName.matches(".*FBI.*"))
//		{
//			System.out.println("요곳도 찾아짐");
//			return true;
//		}
		if(codeName.contains("FBI"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
