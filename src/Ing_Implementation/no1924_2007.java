package Ing_Implementation;

import java.util.Scanner;

public class no1924_2007 {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();

		/* Exceptions */
		if(__exceptionHandler(X, Y) == false)
		{
			return;
		}
		
		/* Main function */
		__Solution(X,Y);
		sc.close();
		return;
	}
	
	private static void __Solution(int Dmonth, int Ddate)
	{
		String Dayarr[] = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		int Montharr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int MonthPointer = 0;
		int nowMonth = 1;
		int nowDate = 1;
		int Daylength = Dayarr.length;
		MonthPointer = __monthMatching(Montharr, Dmonth, nowMonth, MonthPointer, Daylength);
		MonthPointer = __dateMatching(Ddate, nowDate,MonthPointer, Daylength);
		__printDay(Dayarr, MonthPointer);
		
		
	}
	
	private static boolean __exceptionHandler(int X, int Y)
	{
		if(X < 1 || X > 12)
		{
			return false;
		}
		
		if(Y < 1 || Y > 31)
		{
			return false;
		}
		else
		{
			if((X == 4 ||X == 6 || X == 9 || X == 11) && Y > 30)
			{
				return false;
			}
			else if(X==2 && Y > 28)
			{
				return false;
			}
		}
		
		return true;
	}
	
	//월매칭 -> 다음달의 1일의 요일찾아주기
	private static int __monthMatching(int Montharr[], int Dmonth, int nowMonth, int MonthPointer, int Daylength)
	{
		for(int i=nowMonth; i<Dmonth; i++)
		{
			int plusValue = 0; 
			if(nowMonth == Dmonth)
			{
				break;
			}
			else
			{
				plusValue = Montharr[nowMonth-1]%28;
				MonthPointer += plusValue;
				if(MonthPointer >= Daylength)
				{
					MonthPointer -= Daylength;
				}
				nowMonth++;
			}
		}
		return MonthPointer;
	}
	
	
	//일매칭 -> 7씩더하다가 잔여 계산
	private static int __dateMatching(int Ddate, int nowDate, int MonthPointer, int Daylength)
	{
		for(int i=nowDate; i<=Ddate; i+=7)
		{
			if(i == Ddate)
			{
				nowDate = Ddate;
			}
			else
			{
				nowDate = i;
			}
		}
		MonthPointer += (Ddate - nowDate);
		if(MonthPointer >= Daylength)
		{
			MonthPointer -= Daylength;
		}
		
		return MonthPointer;
	}
	
	private static void __printDay(String[] Dayarr,int MonthPointer)
	{
		System.out.println(Dayarr[MonthPointer]);
	}
	
	
	
}
