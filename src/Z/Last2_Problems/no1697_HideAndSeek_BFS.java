package Z.Last2_Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1697
 * 런타임 에러 오지게 났었음 
 * 이유는 문제를 잘 안읽어서임. 
 * 0 <= subin , sister <= 100000 의 범위 였는데 
 * int[100000]으로 크기 할당해주었었음 즉 100000까지 사용하려면 0~100000을 가질 수 있는
 * int[100001]을 선언했어야함. 뻘짓함. 문제 잘 읽자 
 * */
public class no1697_HideAndSeek_BFS {
	static int subin;
	static int sister;
	
	static int input[];
	static int visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		subin = sc.nextInt();
		sister = sc.nextInt();
		
		if(subin == sister)
		{
			System.out.println("0");
			return;
		}
		if(subin < 0 || subin > 100000 || sister < 0 || sister > 100000 )
		{
			return;
		}
		input = new int[100001];
		visit = new int[100001];
		
		input[subin] = 1;
		input[sister] = 1;
		
		BFS(subin);
		
	}
	
	public static void BFS(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		
		int xtool[] = {1,-1,2};
		
		q.offer(start);
		
		while(q.isEmpty() == false)
		{
			
			int spot = q.poll();
			if(spot == sister)
			{
				System.out.println(visit[spot]);
				return;
			}
			
			for(int i=0;i<3;i++)
			{
				int nextspot=0;
				if(i==2)
				{
					nextspot = (spot * xtool[i]);
					if(nextspot <= 100000 && nextspot >= 0)
					{
						if(visit[nextspot] == 0)
						{
							visit[nextspot] = visit[spot]+1;
							q.offer(nextspot);
						}
					}
				}
				if(i==0 || i==1)
				{
					nextspot = spot + xtool[i];
					if(nextspot >= 0 && nextspot <= 100000)
					{
						if(visit[nextspot] == 0)
						{
							visit[nextspot] = visit[spot]+1;
							q.offer(nextspot);
						}
					}
				}
			}
		}
	}
}
