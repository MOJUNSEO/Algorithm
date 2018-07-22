package Problems;

import java.util.Scanner;

public class SWA1949_mountainload {
	static int Testcase = 0;
	static int N = 0;
	static int map[][];
	static int K = 0;
	static int max = Integer.MIN_VALUE;
	static int depthmax = Integer.MIN_VALUE;
	static boolean visit[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Testcase = sc.nextInt();
		for(int i=0;i<Testcase;i++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visit = new int[N][N];
			for(int a = 0; a<N;a++)
			{
				for(int b = 0; b < N ; b++)
				{
					map[a][b] = sc.nextInt();
					if(map[a][b] > max)
					{
						max = map[a][b];
					}
				}
			}
			if(constraint())
			{
				for(int a=0;a<N;a++)
				{
					for(int b=0;b<N;b++)
					{
						if(map[a][b] == max)
						{
							int depth = 1;
							visit[a][b] = true;
							search(a,b,depth);
						}
					}
				}
			}
		}
	}
	private static void search(int col, int row, int depth)
	{
		// up down right left 
		int dist_col[] = {-1,1,0,0};
		int dist_row[] = {0,0,1,-1};
		if(depth > depthmax)
		{
			depthmax = depth;
		}
		
		//문제는백트래킹을 위해서 어디서 visit[a][b]를 돌려놓아야하는가. 
		//높이마다 한번씩 깎아보면서 돌려야한다. K ,k-1,k-2...k=0
		for(int k = K; k >= 0; k--)
		{
			for(int i=0;i<4;i++)
			{
				int nextcol = col + dist_col[i];
				int nextrow = row + dist_row[i];
				// 범위 체크 해주고
				if(nextcol > -1 && nextcol < N)
				{
					if(nextrow > -1 && nextrow < N)
					{
						//아직 방문안했고 
						if(visit[nextcol][nextrow] == false)
						{	
							//현재고지 보다 더 낮으면 
							if(map[col][row] > map[nextcol][nextrow])
							{
								search(nextcol,nextrow,depth+1);
							}
						}
					}
				}
				//문제는 어디서 visit[a][b]를 다시 돌려놓야하는지. 
			}
		}
	}
	
	private static boolean constraint()
	{
		// 3 N 8  -- 1 K 5
		if(N < 3 || N > 8)
		{
			return false;
		}
		if(K < 1 || K > 5)
		{
			return false;
		}
		return true;
	}
}
