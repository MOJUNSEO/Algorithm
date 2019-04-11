package C.Searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no3184_sheeps_BFS {
	static String map[][] = null;
	static boolean visit[][] = null;
	static int dcol[] = {1,-1,0,0};
	static int drow[] = {0,0,-1,1};
	static int sheep= 0;
	static int wolves = 0;
	static int shcnt = 0;
	static int wolvcnt = 0;
	static int row = 0;
	static int col = 0;
	//static 
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		 * 
		 * . = empty feild / # = fence / o = sheep / v = wolf
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		String str[] = null;
		str = sc.nextLine().split("");
		//row
		col = Integer.parseInt(str[0]);
		
		//col
		String makecol = "";
		for(int i=2;i<str.length;i++)
		{
			makecol = makecol + str[i];
		}
		row = Integer.parseInt(makecol);
		
		
		if((col < 3 || col > 250) || (row < 3 || row > 250))
		{
			return;
		}
			
		
		
		map = new String[col][row];
		visit = new boolean[col][row];
		
		//input
		for(int i=0; i < col; i++)
		{
			str = sc.nextLine().split("");
			for(int j=0; j < row; j++)
			{
				map[i][j] = str[j];
			}
		}
		
		sc.close();
		//순회 
		for(int i=0; i < col; i++)
		{
			for(int j=0; j < row; j++)
			{
				if(!map[i][j].equals("#") && visit[i][j] == false)
				{
					BFS(i,j);
					sheep = 0;
					wolves = 0;
				}
			}
		}
		System.out.print(shcnt + " " + wolvcnt);
		
		return;
	}
	
	
	private static void BFS(int input_col, int input_row)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(input_col); q.offer(input_row);
		visit[input_col][input_row] = true;
		
		while(!q.isEmpty())
		{
			int now_col = q.poll();
			int now_row = q.poll();
			
			if(map[now_col][now_row].equals("o"))
			{
				sheep++;
			}
			else if(map[now_col][now_row].equals("v"))
			{
				wolves++;
			}
				
			
			for(int d=0;d<4;d++)
			{
				int next_col = now_col + dcol[d];
				int next_row = now_row + drow[d];
				
				//다음 공간이 배열 안에 있고
				if(next_col > -1 && next_col < col)
				{
					if(next_row > -1 && next_row < row)
					{
						//다음 공간이 아직 방문하지않았고
						if(visit[next_col][next_row] == false)
						{
							//다음 공간이 빈공간,늑대,양이면 넣어라
							if(__insve(map[next_col][next_row]))
							{
								q.offer(next_col);
								q.offer(next_row);
								visit[next_col][next_row] = true;
							}
						}
					}
				}
			}
			
			//
			
			
		}
		
		//한 울타리 내 탐색 마쳤으므로 몇마리 남았는지?
		if(sheep > wolves)
		{
			shcnt += sheep;
		}
		else
		{
			wolvcnt += wolves;
		}
		return;
	}
	
	private static boolean __insve(String value)
	{
		if(value.equals("."))
		{
			return true;
		}
		else if(value.equals("o"))
		{
			return true;
		}
		else if(value.equals("v"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
