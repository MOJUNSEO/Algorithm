package Last2_Problems;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14499
 * 
 * 4 2  0 08
 * 4 2 >	배열 수 
 * 0 0 > 주사위를 올려놓을 좌표 
 * 8 > 명령수 
 * 지도 값 입력받음 
 * 
 * 지도 0 > 주사위 바닥면 수가 칸에 복사 
 * 지도 !=0 > 주사위 칸에 써잇는 수가 지도에 복사, 주사위는 0 
 * */
 
public class no14499_RollingDice_prepSW {
	
	static int dice[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int map[][] = new int[N][M];
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int order_count = sc.nextInt();
		int order[] = new int[order_count];
		
		dice = new int[6]; 
		
		
		if(N < 1 && N > 20 && M < 1 && M > 20)
		{
			return;
		}
		if(x < 0 && x > (N-1) && y < 0 && y > (M-1))
		{
			return;
		}
		
		for(int i=0;i<dice.length;i++)
		{
			dice[i] = 0;
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<order_count;i++)
		{
			order[i] = sc.nextInt();
		}
		
		for(int i=0;i<order_count;i++)
		{
			int v = order[i];
			// north x-1 >= 0
			if(v == 3 && x-1 >= 0)
			{
				move(v);
				x -= 1;				
				if(map[x][y] == 0)
				{
					map[x][y] = dice[3];
				}
				else if(map[x][y] != 0)
				{
					dice[3] = map[x][y];
					map[x][y] = 0;
				}			
			}
			// south x+1 < N
			else if(v == 4 && x+1 < N)
			{
				move(v);
				x += 1; 
				if(map[x][y] == 0)
				{
					map[x][y] = dice[3];
				}
				else if(map[x][y] != 0)
				{
					dice[3] = map[x][y];
					map[x][y] = 0;
				}
			}
			//east y+1 < M
			else if(v == 1 && y+1 < M)
			{
				move(v);
				y += 1;
				if(map[x][y] == 0)
				{
					map[x][y] = dice[3];
				}
				else if(map[x][y] != 0)
				{
					dice[3] = map[x][y];
					map[x][y] = 0;
				}
			}
			//west y-1 >= 0
			else if(v == 2 && y-1 >= 0)
			{
				move(v);
				y -= 1;
				if(map[x][y] == 0)
				{
					map[x][y] = dice[3];
				}
				else if(map[x][y] != 0)
				{
					dice[3] = map[x][y];
					map[x][y] = 0;
				}
			}
		}
		
	
	}
	
	public static void move(int foward)
	{
		int temp[] = new int[6];
		//north
		if(foward == 3)
		{
			temp[0] = dice[1];
			temp[1] = dice[2];
			temp[2] = dice[3];
			temp[3] = dice[0];
			
			temp[4] = dice[4];
			temp[5] = dice[5];
		}
		//south
		else if(foward == 4)
		{
			temp[0] = dice[3];
			temp[1] = dice[0];
			temp[2] = dice[1];
			temp[3] = dice[2];
			
			temp[4] = dice[4];
			temp[5] = dice[5];
		}
		//east
		else if(foward == 1)
		{
			temp[0] = dice[0];
			temp[2] = dice[2];
			
			temp[1] = dice[4];
			temp[3] = dice[5];
			temp[4] = dice[3];
			temp[5] = dice[1];
		}
		//west
		else if(foward == 2)
		{
			temp[0] = dice[0];
			temp[2] = dice[2];
			
			temp[1] = dice[5];
			temp[3] = dice[4];
			temp[4] = dice[1];
			temp[5] = dice[3];

		}
		for(int i=0;i<temp.length;i++)
		{
			dice[i] = temp[i];
		}
		System.out.println(dice[1]);
	}

}
