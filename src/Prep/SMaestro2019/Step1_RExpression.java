package Prep.SMaestro2019;
import java.util.*;
import java.util.regex.*;

/**
 * 
 * @author jsmo
 * 정규식 ,
 * 
 *  어떤 문자열 입력받았을 때 , 아이디, 비밀번호, 이메일, 전화번호 판별.
 */
public class Step1_RExpression {
	static Pattern p = null;
	static Matcher m = null;
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------------------------------");
		System.out.println("데이터 입력 : 1. ID		    2. PASSWORD");
		System.out.println("데이터 입력 : 3. EMAIL	4. PHONENUMBER");
		System.out.println("-------------------------------------");
		String inputType = sc.nextLine();
		
//		if(inputType.equals("1") != true || inputType.equals("2") != true || inputType.equals("3") != true || inputType.equals("4") != true)
//		{
//			System.out.println("메뉴번호를 확인하세요.");
//			return;
//		}
		String inputstr = null;
		
		
		switch(inputType)
		{
		case "1":
			System.out.println("ID 입력 : ");
			inputstr = sc.nextLine();
			checkID(inputstr);
			break;
		case "2":
			System.out.println("PASSWORD 입력 : ");
			inputstr = sc.nextLine();
			checkPASSWORD(inputstr);
			break;
		case "3":
			System.out.println("EMAIL 입력 : ");
			inputstr = sc.nextLine();
			checkEMAIL(inputstr);
			break;
		case "4":
			System.out.println("PHONENUMBER 입력 : ");
			inputstr = sc.nextLine();
			checkPHONENUMBER(inputstr);
			break;
			default : 
				System.out.println("메뉴 번호를 확인하세요.");
				break;
		}
		
		sc.close();
		return;
	}
	
	private static void checkID(String str)
	{
		p = Pattern.compile("(^[A-z0-9!-|1]{4,10}$)");
		m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println("사용할 수 있는 ID 입니다.");
		}
		else
		{
			System.out.println("사용할 수 없는 ID 입니다.");
		}
		
		return;
	}
	
	private static void checkPASSWORD(String str)
	{
		p = Pattern.compile("(^[A-z0-9!-|1]{4,10}$)");
		m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println("사용할 수 있는 PASSWORD 입니다.");
		}
		else
		{
			System.out.println("사용할 수 없는 PASSWORD 입니다.");
		}
		
		return;
	}
	
	// 20190321 이거하고 비트연산 , 진법 문제  
	private static void checkEMAIL(String str)
	{
		p = Pattern.compile("^([A-z0-9])+@([A-z])$");
		m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println("사용할 수 있는 EMAIL 입니다.");
		}
		else
		{
			System.out.println("사용할 수 없는 EMAIL 입니다.");
		}
		
		return;	
	}
	
	private static void checkPHONENUMBER(String str)
	{
		p = Pattern.compile("");
		m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println("사용할 수 있는 PHONENUMBER 입니다.");
		}
		else
		{
			System.out.println("사용할 수 없는 PHONENUMBER 입니다.");
		}
		
		return;
	}

}
