package Prep.SMaestro2019;
import java.util.*;
import java.util.regex.*;


public class pbm_kakao1_phonenumber {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		String phn = sc.nextLine();
		
		if(phn.length() < 1 || phn.length() > 30)
		{
			System.out.println(-1);
			return;
		}
		
		//010-0000-0000
		Pattern p1 = Pattern.compile("^010-([0-9]{4})-([0-9]{4})$");
		Matcher m1 = p1.matcher(phn);
		
		//010 0000 0000
		Pattern p2 = Pattern.compile("^010([0-9]{8})$");
		Matcher m2 = p2.matcher(phn);
		
		//+82-10-0000-0000
		// 정규식 기호에서는 + 를 []로 감쌀 것.
		Pattern p3 = Pattern.compile("^[+]82-10-([0-9]{4})-([0-9]{4})$");
		Matcher m3 = p3.matcher(phn);
		
		
		if(m1.find())
		{
			System.out.println(1);
			return;
		}
		else if(m2.find())
		{
			System.out.println(2);
			return;
		}
		else if(m3.find())
		{
			System.out.println(3);
			return;
		}
		else 
		{
			System.out.println(-1);
			return;
		}
	}
}
