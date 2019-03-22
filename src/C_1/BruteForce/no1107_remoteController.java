package C_1.BruteForce;

import java.util.Scanner;
/*
 * 백준 1107 리모컨 , 브루트 포스
 * 
 *  How to solve this problem
 *  
 *  range -> 0 ~ 1,000,000. 0~500,000(+) to 500,000 ~ 1,000,000(-)
 *  divide to channel Number. Method1 -> Using String, Method2 -> using symbol of "%10"
 *  
 *  0. Do working of setting.(input, declare variable, exception)
 *  1. Channel Number - 100.
 *  2. Dividing Number.
 *  3. Calculate.
 * */
public class no1107_remoteController {
	/* variable */
	static int cnum = 0; // Channel number was declared.
	static int bnum = 0; // the number of broken btn.
	static int result = 0;
	static boolean bcarr[] = new boolean[10]; // check broken btns.
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		//input variable.
		cnum = sc.nextInt();
		bnum = sc.nextInt();
		
		//init array.
		for(int i=0;i<bcarr.length;i++)
		{
			bcarr[i] = true;
		}
		
		//insert variable to array according to conditions.
		for(int i=0;i<bnum;i++)
		{
			int temp = sc.nextInt();
			bcarr[temp] = false;
		}
		
		// initial channel value is 100. so have to minus -100 from the value.
		result =  cnum - 100;
		if(result < 0)
		{
			result = -result;
		}
		
		//The point of this problem is Brute_force. Keep in mind.
		for(int i=0;i<=1000000;i++)
		{
			int c = i;
			int len = possible(c);
			
			//if the "i" is available, start calculation. 
			if(len > 0)
			{
				int press = c - cnum;
				
				//Convert to absolute value.
				if(press < 0)
				{
					press = -press;
				}
				
				//1. "press" is the number of times that user press + or -.
				//1. "len" is the number of times that user press a Number.
				//2. Update the minimum value.
				if(result > press + len)
				{
					result = press + len;
				}
			}
		}
		
		//print the result.
		System.out.println(result);
		
	}
	
	// 1~1,000,000 범위의 숫자들을 가지고 고장난 btn이 포함되어 있는지 아닌지 판별.
	// The role of this function.
	// 1. Separate Numbers.
	// 2. Check broken btns in Numbers that were separated.
	// 2. Return a degit. This means the number of pressing a number.
	// 0. Exception.(c == ) Remote Conroller has btn 0.
	// 
	private static int possible(int c)
	{
		int len = 0;
		while(c > 0)
		{
			// Exception, if c == 0, fall into infinity loop.
			if(c == 0)
			{
				if(bcarr[0] == false)
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}
			// % returns the last degit of the number.
			// if the last degit is not available, return 0.
			if(bcarr[c%10] == false)
			{
				return 0;
			}
			//if it is available number, move to next degit.
			len += 1;
			c = c/10;
		}
		
		return len;
	}
}
