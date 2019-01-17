package Ing_StringProblems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no2941_croatiaAlphabet {
	public static void main(String args[])
	{
		String Word = null;
		
		Scanner sc = new Scanner(System.in);
		
		Word  = sc.nextLine();
		
		__Solution(Word);
		
		sc.close();
		return;
	}
	
	private static void __Solution(String Word)
	{
		String checkBox[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int count = 0;
		
		Pattern p = null;
		Matcher m = null;
		
		for(int i=0; i<checkBox.length; i++)
		{
			p = Pattern.compile(checkBox[i]);
			m = p.matcher(Word);
			while(m.find() != false)
			{
				count++;
			}
			Word = Word.replace(checkBox[i], " ");
			
		}
		String restAlpha[] = Word.split("");
		
		for(String a : restAlpha)
		{
			if(a.matches("([a-z])") || a.matches("([A-Z])"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
