package Z.Last_Problems;

import java.util.Scanner;


public class Addcycle {
	public static void main(String[] args) {
		int base; // ó�� ����
		int temp;
		int a; // �и��� ����1
		int b; // �и��� ����2
		int addab;
		
		int count=0;
		
		Scanner sc = new Scanner(System.in);
		
		base = sc.nextInt();		
		
		if(base < 0 || base > 99)
		{			
			return;
		}
		
		temp = base;
		
		while(true)
		{			
			count++;
			b = (temp%10);
			a = (temp - b)/10;
			
			addab = (a+b);
			
			int addb = (addab%10);			
		
			temp = (b*10)+addb;			
			if(temp == base)
			{				
				System.out.println(count);
				return;
			}			
			
			
		}
	}
}
