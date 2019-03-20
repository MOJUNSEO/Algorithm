package Prep.kakakoProblems;
import java.util.Scanner;
import java.util.Stack;

public class kk1_dart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int result = solution(input);
		System.out.println(result);
						
	}
	
	static int solution(String dartResult)
	{
		Stack<Integer> s = new Stack<>();
		
		int num = 0;
		int answer = 0;
		String bonus = "";
		String opt = "";
		
		for(int i=0;i<dartResult.length();i++)
		{
			String temp = dartResult.substring(i, i+1);
			if(temp.matches("^[0-9]*$"))
			{
				if(temp.equals("1") && dartResult.substring(i+1,i+2).equals("0"))
				{
					s.push(10);
					i++;
				}
				else
				{
					s.push(Integer.parseInt(temp));
				}
			}
			else if(temp.matches("^[A-z]*$"))
			{
				switch(temp)
				{
				case "S" : num = s.pop();
				num = (int) Math.pow(num, 1);
				s.push(num);
					break;
				case "D" : num = s.pop();
				num = (int) Math.pow(num, 2);
				s.push(num);
					break;
				case "T" : num = s.pop();
				num = (int) Math.pow(num, 3);
				s.push(num);
					break;
				}
			}
			else if(temp.equals("#") || temp.equals("*"))
			{
				switch(temp)
				{
				case "#" : 
					num = s.pop();
					num = -num;
					s.push(num);
					break;
				case "*" : 
					num = s.pop();
					if(s.isEmpty())
					{
						num = num*2;
						s.push(num);
					}
					else // 2번째 부터 
					{
						int num2 = s.pop();
						num2 = num2*2;
						s.push(num2);
						num = num*2;
						s.push(num);
					}
					break;
				}
			}
		}
		
		while(!s.empty())
		{
			answer += s.pop();
		}
		
		return answer;
	}



}
