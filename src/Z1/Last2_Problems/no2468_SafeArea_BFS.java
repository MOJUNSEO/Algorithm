package Z1.Last2_Problems;
/*
 * https://www.acmicpc.net/problem/2468
 * q.add를 두번하는 것을 ArrayList로 수정하여 다시해보자 
 * 1번 틀렸었음 > ㅈㄴ빡치는게 비가 아예 안 올 때도 고려했어야함;
 * */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no2468_SafeArea_BFS {
	static int map[][];
	static int visit[][];
	static int N;
	static int max_height = 0;
	static int max_area = 0;
	static int area = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N < 2 || N > 100)
		{
			return;
		}
		
		map = new int[N][N];
		visit = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0;j<N;j++)
			{
				int temp = sc.nextInt();
				if(temp > 0 && temp <= 100)
				{
					if(temp > max_height)
					{
						max_height = temp;
					}
					map[i][j] = temp;
				}
			}
		}
		
		//높이를 1~max_height까지 다해본다 (정해진 높이가 없으므로)
		for(int height = 0; height <= max_height; height++)
		{
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					//해당값에 대한 방문배열의 값이 0(미방문)이면서 map의 height가 잠기지 않는 높이 값이라면
					//탐색 진행 
					if(visit[i][j] == 0 && map[i][j] > height)
					{
						BFS(i,j,height);
						//BFS탐색을 하면 area 안전지역 범위 개수 증가 
						area++;
					}
				}
			}
			//해당 height 값에 대해 탐색 진행 후 최대 안전 범위 개수가 더 높다면 갱
			if(area > max_area)
			{
				max_area = area;
			}
			//다음 높이 개수를 구해야하기 때문에 리셋 
			area = 0;
			//다음 높이에 대해 방문배열을 사용해야하기 때문에 리셋 
			resetVisit(visit);
		}
		//각 높이 별 중 최대 안전 개수를 출력 
		System.out.println(max_area);
	}
	
	public static void BFS(int col,int row, int now_height)
	{
		int d_col[] = {1,-1,0,0};
		int d_row[] = {0,0,1,-1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(col);
		q.add(row);
		
		visit[col][row] = 1;
		while(!q.isEmpty())
		{
			int now_col = q.poll();
			int now_row = q.poll();
			
			//상 하 좌 우 조건 넣기 
			for(int d=0; d<4; d++)
			{
				int next_col = now_col + d_col[d];
				int next_row = now_row + d_row[d];
				//다음 스팟이 배열 범위 내 인지 
				if(next_col > -1 && next_col < N && next_row > -1 && next_row < N)
				{
					//다음 스팟에 아직 방문 안했는지 
					if(visit[next_col][next_row] == 0)
					{
						//다음 스팟의 높이값이 현재 height보다 큰지
						if(map[next_col][next_row] > now_height)
						{
							//방문 기록을 남기고 
							visit[next_col][next_row] = 1;
							//크다면 다음 스팟값을 q.add한다 
							q.add(next_col);
							q.add(next_row);
						}
					}
				}
			}
			
		}
		
		
	}
	
	public static void resetVisit(int visitmap[][])
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				visitmap[i][j] = 0;
			}
		}
	}
}
