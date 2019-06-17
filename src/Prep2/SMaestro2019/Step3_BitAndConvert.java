package Prep2.SMaestro2019;
/**
 * 
 * 여기는 비트연산 && 진법 변환 테스팅
 * @author jsmo
 *
 */

import java.util.*;
import java.util.regex.*;

public class Step3_BitAndConvert {
	static Scanner sc = null;
	
	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		int getNum = 0;
		int fromA = 0;
		int toB = 0;
		String fromAstr = null;
		while(true)
		{
			System.out.println("---------------------------------------");
			System.out.println("1. 진법 변환	    2. 비트연산");
			System.out.println("3. 10진수로 변환	4. 종료");
			System.out.println("---------------------------------------");
			getNum = sc.nextInt();
			switch(getNum)
			{ 
			case 1 :
				System.out.println("-> 입력 : X, 진법 ");
				fromA = sc.nextInt();
				toB = sc.nextInt();
				ConvertAtoB(fromA, toB);
				break;
			case 2 :
				System.out.println("-> 입력 : X ");
				fromA = sc.nextInt();
				BitController(fromA);
				break;
			case 3 : 
				System.out.println("-> 입력 : 10진수 / 입력된 진법 ");
				fromAstr = sc.next();
				toB = sc.nextInt();
				ConvertAto10(fromAstr, toB);				
				break;
			case 4 :
				System.out.println("종료");
				sc.close();
				return;
				default : 
					System.out.println("메뉴 번호를 확인하세요.");
			}
		}
		
	}
	
	/**
	 * 
	 * @param fromA 변환하고자 하는 수
	 * @param toB 표현하고자하는 진법 
	 */
	private static void ConvertAtoB(int fromA, int toB)
	{
		int semiresult = fromA;
		int val = -1;
		String result = "";
		
		while(semiresult != 0)
		{
			val = semiresult % toB;
			if(val < 10)
			{
				result = String.valueOf(val) + result;
			}
			else
			{
				int temp = (char)(val + 65);
				result = String.valueOf(temp) + result;
			}
			semiresult /= toB;
		}
		
		System.out.println(result);
		return;
	}
	
	private static void usFuncConvertAtoB(int fromA, int toB)
	{
		String output = null;
		
		if(toB == 2)
		{
			output = Integer.toBinaryString(fromA);
		}
		else if(toB == 8)
		{
			output = Integer.toOctalString(fromA);
		}
		else if(toB == 16)
		{
			output = Integer.toHexString(fromA);
		}
		else
		{
			System.out.println("진법 확인하세요.");
		}
		return;
	}
	/**
	 * 
	 * @param fromA 변환하고자하는 수
	 * @param fromWay 그에 해당한 진법표기 
	 */
	private static void ConvertAto10(String fromA, int fromWay)
	{
		if(fromWay == 2)
		{
			System.out.println(Integer.parseInt(fromA,2));
		}
		else if(fromWay == 8)
		{
			System.out.println(Integer.parseInt(fromA,8));
		}
		else if(fromWay == 16)
		{
			System.out.println(Integer.parseInt(fromA,16));
		}
		else
		{
			System.out.println("진법 확인하세요.");
		}
		return;
	}
	
	private static int Valuepow(int value, int powValue)
	{
		/**
		 * Math.pow(x, 제곱) 을 직접 구현
		 */
		
		if(powValue == 0)
		{
			return 1;
		}
		if(powValue == 1)
		{
			return value;
		}
		
		
		int result = value;
		for(int i=0;i<powValue-1;i++)
		{
			result = result*value;
		}
		return result;
	}

	/**
	 * 1bit = 0,1 을 담을수있음
	 * 8bit = 1byte(+-127) = 1 char
	 * 16bit = 2byte = 1short(+-32767)
	 * 32bit = 4byte = 2short = 1int(+-21억)
	 * long = 경 넘어감.
	 * bit 연산은 byte, short, char, int, long 에서만 사용가능.
	 * 
	 * 명시적 -> Long 타입경우 4492762L, Float 타입경우 130.472F 써줌.
	 * 
	 * @return
	 */
	private static int BitController(int value)
	{
		/**
		 * 
		 * AND / OR / ^(XOR, 둘이 다를 때 1) / ~(NOT, 반대 값 반환)
		 * 비트연산의 기준은 2진법으로 변환했을 때 결과 값들임.
		 * 
		 *  << 왼쪽으로 X 칸 밀고 부호비트로 채움
		 *  >> 오른쪽으로 X 칸 밀고 부호비트로 채움
		 *  <<< , >>> 각 방향으로 밀고 0으로 채움. 
		 *  
		 */
		System.out.println("기존 데이터 -> " + value);
		System.out.println("기존 데이터 2진수로 변환 -> " + Integer.toBinaryString(value));
		int shiftL2 = (value << 2);
		System.out.println(" 왼쪽으로 Shift <<  2 -> [ " + shiftL2 + " ] 2진수로 변환 -> " + Integer.toBinaryString(shiftL2));
		int shiftR3 = (value >> 1);
		int shiftRR3 = (value >> 1);
		System.out.println(" 오른쪽으로 Shift >>  1 -> [ " + shiftR3 + " ] 2진수로 변환 -> " + Integer.toBinaryString(shiftR3));
		System.out.println(" 오른쪽으로 Shift >>> 1 -> [ " + shiftRR3 + " ] 2진수로 변환 -> " + Integer.toBinaryString(shiftRR3));
		return 0;
	}

}
