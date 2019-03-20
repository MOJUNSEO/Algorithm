package Z.Last2_Problems;
/*
 * https://www.acmicpc.net/problem/1012
 * 섬 개수 세는 것과 비슷, DFS마다 번호를 붙여주는 방법을 알 수 있다.
 * TestCase의 경우 결과를 저장했다가 한 번에 출력해야 더블입력 오류를 방지할 수 있다. 
 * */
import java.util.Scanner;

public class no1012_BaeChuu_DFS {
		static int[][] map;
		static int[][] visit;
		static int col;
		static int row;
		static int min_worm = 0;
		static int worm[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		worm = new int[testcase];
		for(int cycle=0;cycle<testcase;cycle++)
		{
			col = sc.nextInt();
			row = sc.nextInt();
			int baechu = sc.nextInt();
			//check range
			if(col < 1 && col > 50 && row < 1 && row > 50)
			{
				return;
			}
			if(baechu < 1 && baechu > 2500)
			{
				return;
			}
			//map init
			map = new int[col][row];
			visit = new int[col][row];
			
			for(int i=0;i<col;i++)
			{
				for(int j=0;j<row;j++)
				{
					map[i][j] = 0;
					visit[i][j] = 0;
				}
			}
			
			//map setting
			for(int i=0; i<baechu;i++)
			{
				int inputcol = sc.nextInt();
				int inputrow = sc.nextInt();
				map[inputcol][inputrow] = 1;
			}
			
			//start Algorithm
			for(int i=0;i<col;i++)
			{
				for(int j=0;j<row;j++)
				{
					if(map[i][j] == 1 && visit[i][j] == 0)
					{
						DFS(i,j);
						min_worm++;
					}
				}
			}
			worm[cycle] = min_worm;
			min_worm = 0;
		}
		for(int i : worm)
		{
			System.out.println(i);
		}
	}
	
	public static void DFS(int colx, int rowy)
	{
		int d_col[] = {1,-1,0,0};
		int d_row[] = {0,0,1,-1};
		//already visit to x,y > return
		if(map[colx][rowy] == 0 && visit[colx][rowy] != 0)
		{
			return;
		}
		// if not visit x,y, input worm
		visit[colx][rowy] = 1;
		
		for(int i=0;i<4;i++)
		{
			int next_colx = colx + d_col[i];
			int next_rowy = rowy + d_row[i];
			
			// range in map length
			if(next_colx >= 0 && next_colx < col && next_rowy >= 0 && next_rowy < row)
			{
				// baechu existed in map && not visit yet
				if(map[next_colx][next_rowy] == 1 && visit[next_colx][next_rowy] == 0)
				{
					DFS(next_colx,next_rowy);
				}
			}
		}
	}
}
