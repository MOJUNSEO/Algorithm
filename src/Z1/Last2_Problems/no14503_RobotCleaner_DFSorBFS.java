package Z1.Last2_Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14503
 * 
 * */
public class no14503_RobotCleaner_DFSorBFS 
{
	static int N = 0;
	static int M = 0;
	static int map[][];
	static boolean visit[][];
	//북,동,남,서
	static int way[];
	static int mask_c[] = {-1,0,1,0};
	static int mask_r[] = {0,1,0,-1};
	static int count=0;
	public static void main(String[] args) 
	{
 		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		way = new int[4];
		
		int Rrow = sc.nextInt();
		int Rcol = sc.nextInt();
		int direction = sc.nextInt();
		
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				map[i][j] = sc.nextInt();
			}
		}

		Bfs(Rcol,Rrow,direction);
		System.out.println(count);
	}
	
	private static void Countsection()
	{
		int count = 0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(visit[i][j] == true)
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	//청소를 하면 1로 만듬 
	public static void Bfs(int startcol, int startrow, int direction)
	{
		Queue<robot> q = new LinkedList<>();		
		q.add(new robot(startcol, startrow, direction));
		
		++count;
		visit[startcol][startrow] = true;
		
		while(!q.isEmpty())
		{
			int ncol = q.peek().col;
			int nrow = q.peek().row;
			int ndi = q.poll().di;
			boolean noanyway = true;
			//갈수 잇는곳이 잇으면 
			for(int i=0;i<4;i++)
			{
				//현재 방향이 북쪽 이면 다음탐색은 서쪽  
				//지금 방향이 서쪽이면 다음은 남쪽 
				//지금 방향이 남쪽이면 동쪽 
				//지금 방향이 동쪽이면 북쪽
				int nextdi = nextsearchway(ndi);
				int nextcol = ncol + mask_c[nextdi];
				int nextrow = nrow + mask_r[nextdi];
				if(nextcol > -1 && nextcol < N)
				{
					if(nextrow > -1 && nextrow < M)
					{
						if(map[nextcol][nextrow] == 0 && visit[nextcol][nextrow] == false)
						{
							visit[nextcol][nextrow] = true;
							++count;
							q.add(new robot(nextcol, nextrow, nextdi));
							noanyway = false;
							break;
						}
					}
				}
			}
			if(noanyway == true)
			{
				int backdi = backdirection(ndi);
				int backcol = ncol + mask_c[backdi];
				int backrow = nrow + mask_r[backdi];
				if(backcol > -1 && backcol < N && backrow > 0 &&backrow < M)
				{
					if(map[backcol][backrow] == 0)
					{
						q.add(new robot(backcol,backrow,ndi));
					}
				}
				//현재 방향에서 북이면 남, 
				//남이면 북 
				//동이면 서 
				//서면 동 으로 2칸.
			}
			
		}
	}
	
	private static int backdirection(int direction)
	{
		int returnway = -1;
		//북 - > 남 
		//북,동,남,서
		if(direction == 0)
		{
			returnway = 2;
		}
		//남- >  북 
		else if(direction == 1)
		{
			returnway = 3;
		}
		//동 - > 서  
		else if(direction == 2)
		{
			returnway = 0;
		}
		//서  - > 동  
		else if(direction == 3)
		{
			returnway = 1;	
		}
		return returnway;
	}
	
	//바라보는 방향에서 왼쪽으로 방향바꿔줌 
	private static int nextsearchway(int direction)
	{
		//북,동,남,서
		//현재 방향이 북쪽 이면 다음탐색은 서쪽  
		//지금 방향이 서쪽이면 다음은 남쪽 
		//지금 방향이 남쪽이면 동쪽 
		//지금 방향이 동쪽이면 북쪽 
		if(direction == 0)
		{
			return 3; 
		}
		else if(direction == 1)
		{
			return 0;
		}
		else if(direction == 2)
		{
			return 1;
		}
		else if(direction == 3)
		{
			return 2;
		}
		return -1;
	}
}
	class robot
	{
		int col;
		int row;
		int di;
		public robot(int icol, int irow, int idi)
		{
			this.col = icol;
			this.row = irow;
			this.di = idi;
		}
	}





