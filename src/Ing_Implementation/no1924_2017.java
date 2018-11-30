package Ing_Implementation;

import java.util.Scanner;

//제일 가까운 월요일을 찾는다. ex) 7일씩 게속더해서 전주 월요일을 찾음. -> 남은 숫자만큼 더하면서 요일카운트
public class no1924_2017 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month =  sc.nextInt();
		int date = sc.nextInt();
		
		if(month < 1 || month > 12)
		{
			if(date < 1 || date > 31)
			{
				return;
			}
		}
		else
		{
			Solution(month, date);
		}
		
		sc.close();
		return;
	}
	
	static void Solution(int month, int date)
	{
		int monthcount = 1;
		int datecount = 1;
		int daycount = 0;
		int monthday[] = {31,28,31,30,31,30,31,31,30,31,31,31};
		
		for(int k=0;k<12;k++)
		{
			for(int i=0;i<monthday[k];i++)
			{
				if(month == monthcount)
				{
					if(date == datecount)
					{
						printDay(daycount);
						return;
					}
				}
				else
				{
					datecount++;
					if(daycount == 6)
					{
						daycount = 0;
					}
					else
					{
						daycount++;
					}
				}
			}
			monthcount++;
			datecount = 1;
		}
		System.out.println(monthcount + " / " + datecount + " 요일 : " + daycount);
		return;
	}
	
	static int returnDay(int daycount)
	{
		if(daycount == 6)
		{
			return 0;
		}
		else
		{
			return daycount+1;
		}
	}
	
	static void printDay(int daycount)
	{
		switch(daycount)
		{
		case 0:
			System.out.println("MON");
			break;
		case 1:
			System.out.println("TUE");
			break;
		case 2:
			System.out.println("WED");
			break;
		case 3:
			System.out.println("THU");
			break;
		case 4:
			System.out.println("FRI");
			break;
		case 5:
			System.out.println("SAT");
			break;
		case 6:
			System.out.println("SUN");
			break;
		}
		return;
	}
}
