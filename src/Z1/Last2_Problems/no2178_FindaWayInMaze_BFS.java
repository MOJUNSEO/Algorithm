package Z1.Last2_Problems;

/*
 * https://www.acmicpc.net/problem/2178
 * 상/하/좌/우 필터 입히는 방법을 알게됨 기본적인 BFS적용방식에 대해 알게됨  
 * BFS의 가장 중요한 것은 조건을 적용시키면서 다음 정점을 큐에 push하는 것.
 * */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no2178_FindaWayInMaze_BFS {
	static int col;
	static int row;
	static int input[][];
	static int visit[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		col = sc.nextInt();
		row = sc.nextInt();
		
		if(col < 2 || row > 100)
		{
			return;
		}
		
		input = new int[col][row];
		visit = new int[col][row];
		
		
		for(int i=0;i<col;i++)
		{
			String temp = sc.next();
			for(int j=0;j<row;j++)
			{
				input[i][j] = temp.charAt(j)-'0';
			}
		}
		
		BFS(0,0);
		sc.close();
}
		
		
		
	
	public static void BFS(int start_col, int start_row)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start_col);
		q.add(start_row);
		
		//스타트 지점 방문 기록해놓음 (0,0)
		visit[start_col][start_row] = 1;
		
		//상, 하, 좌, 우 
		int xtool[] = {-1,1,0,0};
		int ytool[] = {0,0,-1,1};
		while(q.isEmpty() == false)
		{
			int vertex_col = q.poll();
			int vertex_row = q.poll();
			// (0,0) 기준으로 갈 수 있는 길을 파악해야
			if(vertex_col == col-1 && vertex_row == row-1)
			{
				System.out.println(visit[vertex_col][vertex_row]);
				return;
			}
			for(int i=0;i<4;i++)
			{
				int next_col = vertex_col + xtool[i];
				int next_row = vertex_row + ytool[i];
				// i=0 > 상 / i=1 > 하 / i=2 > 좌 / i=3 > 우 
				
				// 배열 범위 안에 있고  
				if(next_col >= 0 && next_row >= 0 && next_col < col && next_row < row)
				{
					// 방문 기록 없고 
					if(visit[next_col][next_row] == 0)
					{
						// 지나갈 수 있는 길이라면 
						if(input[next_col][next_row] == 1)
						{
							// 어차피 두 갈래 길이어도 상관없다 잘릴거니까 
							q.offer(next_col);
							q.offer(next_row);
							visit[next_col][next_row] = visit[vertex_col][vertex_row]+1;
						}
					}
				}
			}
		}
	}
}
