package Ing_Implementation;

import java.util.*;

/* 베르트와 공준 */
/* 에레스토텔레스의 체를 적용하여, 소수구하는 범위를 줄임. */
/* 1~N까지 소수를 구할 때. 보통 1에서 N사이의 수를 직접 %연산하여 나머지가 0인경우를 필터했음.
 * 수학공식 : 2부터 범위내 최대수의 제곱근까지로 나누는 것 = 2부터 범위내 최대수까지 직접 나누는 것. 결과는 같지만, 연산 횟수가 다르다.
 * 즉 공식을 쓰면 시간복잡도를 줄일 수 있따.
 *  */
public class no4948_BrteGongjun {
	
	public static void main(String args[])
	{
		__Solution();
		return;
	}
	
	private static void __Solution()
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int Value = sc.nextInt();
			if(Value > 123456 || Value < 0)
			{
				return;
			}
			else if(Value == 0)
			{
				break;
			}
			else
			{
				__Calculation(Value);
			}
		}
		sc.close();
		return;
	}
	
	private static void __Calculation(int N)
	{
		int Count = 0;
		if(N == 1)
		{
			System.out.println(1);
			return;
		}
		
		//에레스토테니스 체 적용 
			for(int i=(N+1); i<=(2*N); i++)
			{
			
				for(int j=2;j<=(int)Math.sqrt(2*N);j++)
				{
					if(i%j == 0)
					{
						break;
					}
					else
					{
						if(j==(int)Math.sqrt(2*N))
						{
							Count++;
						}
					}
					
				}
			}
		System.out.println(Count);
		return;
	}
}
