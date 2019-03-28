package F.Stack_Memoization;

import java.util.*;
public class Stack_parentheses {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split("");
		
		Solution(str);
		
		sc.close();
		return;
	}
	/**
	 * condition1. )부터 나올 때.
	 * condition2. ( 덩그러니 남을 때. 
	 * condition3.  
	 * @param str
	 */
	private static void Solution(String str[])
	{
		
		Stack<String> s = new Stack<>();
		int count = 1;
		for(int i=0;i<str.length;i++)
		{
			if(str[i].equals("("))
			{
				s.push(str[i]);
				continue;
			}
			
			//1
			if(s.empty() && str[i].equals(")"))
			{
				System.out.println("miss1");
				return;
			}
			if(!s.empty() && str[i].equals(")"))
			{
				System.out.println(count);
				count++;
				s.pop();
			}
			
		}
		//2
		if(!s.empty())
		{
			System.out.println("miss2");
			return;
		}
		
		System.out.println("pass3");
		return;
	}
	
}
