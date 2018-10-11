package Last2_Problems;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14888
 * 
 * Dfs(depth+1,sum+arr[depth+1],plus+1,minus,multi,divide);
 * sum += arr[depth+1]
 * Dfs(depth+1,sum,plus+1,minus,multi,divide);
 * 의 차이가 뭔지; 위의 식으로 할 때 정상값 나옴. 
 * 여기서의 완전탐색은 시작을 다 정해줌. 
 * */

public class no14888_operator_DFS {
	static int N = 0;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int plus_in, minus_in, multi_in, divide_in;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		plus_in = sc.nextInt();
		minus_in = sc.nextInt();
		multi_in = sc.nextInt();
		divide_in = sc.nextInt();
		Dfs(0,arr[0],0,0,0,0);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	
	private static void Dfs(int depth, int sum, int plus, int minus, int multi, int divide)
	{
		if(depth == N-1)
		{
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		else
		{
			if(plus < plus_in)
			{
				Dfs(depth+1,sum+arr[depth+1],plus+1,minus,multi,divide);
			}
			if(minus < minus_in)
			{
				Dfs(depth+1,sum-arr[depth+1],plus,minus+1,multi,divide);
			}
			if(multi < multi_in)
			{
				Dfs(depth+1,sum*arr[depth+1],plus,minus,multi+1,divide);
			}
			if(divide < divide_in)
			{
				int temp = 0;
				if(sum < 0)
				{
					sum = Math.abs(sum);
					sum /= arr[depth+1];
					temp = -sum;
				}
				else
				{
					temp = sum/arr[depth+1];
				}
				Dfs(depth+1,temp,plus,minus,multi,divide+1);
			}
		}
	}
}
