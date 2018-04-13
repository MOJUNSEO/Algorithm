package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14503
 * */
public class no14503_RobotCleaner_DFSorBFS {
	static int N = 0;
	static int M = 0;
	static int map[][];
	static int visit[][];
	//북,서,남,동
	static int way[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		way = new int[4];
		
		int Rrow = sc.nextInt();
		int Rcol = sc.nextInt();
		int direction = sc.nextInt();
		
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		//북,서,남,동
		switch(direction)
		{
		 case 0 :
			 //북
			 way[0] = 1;
			 break;
		 case 1 :
			 //동
			 way[3] = 1;
			 break;
		 case 2 :
			 //남
			 way[2] = 1;
			 break;
		 case 3 :
			 //서
			 way[1] = 1;
			 break;
			
		}
		
		Bfs(Rcol,Rrow,direction);
		
		
	}
	
	//청소를 하면 1로 만듬 
	public static void Bfs(int startcol, int startrow, int direction)
	{
		int maskcol = {};
		Queue<robot> q = new LinkedList<>();		
		q.add(new robot(startcol, startrow, direction));
		
		visit[startcol][startrow] = 1;
		
		while(!q.isEmpty())
		{
			int ncol = q.peek().col;
			int nrow = q.peek().row;
			int ndi = q.poll().di;
			//갈수 잇는곳이 잇으면 
			if(check4way(ncol,nrow) == true)
			{
				//왼쪽방향 탐색해야함
				int nextdi = changeleft(ndi);
				
				//방향을 가지고 발견될때까지 반복해야할듯 
			}
			else
			{
				//뒤방향 확인해서 후진못하면 끝
				//후진 할 수 있으면 후진좌표 add
			}
			
		}
	}
	
	private static boolean check4way(int nowcol, int nowrow)
	{
		//좌,상,하,우
		int maskcol[] = {0,-1,1,0};
		int maskrow[] = {-1,0,0,1};
		int ncol = nowcol;
		int nrow = nowrow;
		boolean result = true;
		for(int i=0;i<4;i++)
		{
			int nextcol = ncol + maskcol[i];
			int nextrow = nrow + maskrow[i];
			//갈 수 있으면 true
			if(nextcol > -1 && nextcol < N && nextrow > -1 && nextrow < M)
			{
				//벽이 아니고
				if(map[nextcol][nextrow] != 1)
				{
					//아직 방문안했으면
					if(visit[nextcol][nextrow] != 1)
					{
						return result;
					}
				}
				else
				{
					result = false;
					return result;
				}
			}
			else
			{
				result = false;
				return result;
			}
		}
		return result;
	}
	
	//바라보는 방향에서 왼쪽으로 방향바꿔줌 
	private static int changeleft(int direction)
	{
		//북,서,남,동
		int returnway = 0;
		if(way[direction] == 1)
		{
			//북 - >서
			if(direction == 0)
			{
				way[direction] = 0;
				way[1] = 1;
				returnway = 1;
			}
			// 동 -> 북
			else if(direction == 1)
			{
				way[direction] = 0;
				way[0] = 1;
				returnway = 0;
			}
			// 남 -> 동
			else if(direction == 2)
			{
				way[direction] = 0;
				way[3] = 1;
				returnway = 3;
			}
			// 서 -> 남
			else if(direction == 3)
			{
				way[direction] = 0;
				way[2] = 1;
				returnway = 2;
			}
		}
		return returnway;
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
