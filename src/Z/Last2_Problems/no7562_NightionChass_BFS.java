package Z.Last2_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/7562
 * 
 * 최소 움직임을 구하는 내용이므로 BFS가 적절하다고 판단된다. 
 * */
public class no7562_NightionChass_BFS {
	static int testcase = 0;
	static int mapsize = 0;
	static int now_col = 0;
	static int now_row = 0;
	static int final_col = 0;
	static int final_row = 0;
	static int map[][];
	static int output[];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		testcase = Integer.parseInt(in.readLine());
		output = new int[testcase];
		
		for(int T = 0; T < testcase ; T++)
		{
			mapsize = Integer.parseInt(in.readLine());
			map = new int[mapsize][mapsize];
			
			//init
			for(int i=0; i < mapsize ; i++)
			{
				for(int j= 0; j < mapsize ; j++)
				{
					map[i][j] = -1;
				}
				
			}
			
			String temp[] = in.readLine().split(" ");
			now_col = Integer.parseInt(temp[0]);
			now_row = Integer.parseInt(temp[1]);
			
			temp = in.readLine().split(" ");
			final_col = Integer.parseInt(temp[0]);
			final_row = Integer.parseInt(temp[1]);
			move(T);
		}
		for(int a : output)
		{
			System.out.println(a);
		}
	}
	
	static void move(int tcase)
	{
		//왼쪽위1-2, 오른쪽위1-2, 왼쪽아래1-2, 오른쪽아래1-2 
		int dist_col[] = {-1,-2,-1,-2,1,2,1,2};
		int dist_row[] = {-2,-1,2,1,-2,-1,2,1};
		Queue<coordinate> q = new LinkedList<>();
		
		map[now_col][now_row] = 0;
		q.offer(new coordinate(now_col, now_row));
		
		while(!q.isEmpty()) 
		{
			int temp_col = q.peek().col;
			int temp_row = q.poll().row;
			for(int i = 0; i < 8; i++)
			{
				int next_col = temp_col + dist_col[i];
				int next_row = temp_row + dist_row[i];
				if(next_col >= 0 && next_col < mapsize)
				{
					if(next_row >= 0 && next_row < mapsize)
					{
						if(map[next_col][next_row] == -1 || map[temp_col][temp_row] + 1 < map[next_col][next_row])
						{
							if(next_col == final_col && next_row == final_row)
							{	
								output[tcase] = map[temp_col][temp_row] + 1;
								return;
							}
							else
							{
								map[next_col][next_row] = map[temp_col][temp_row]+1;
								q.offer(new coordinate(next_col,next_row));
							}	
						}
					}
				}
			}
		}
		
		
	}
}

class coordinate {
	int col;
	int row;
	
	public coordinate(int input_col, int input_row) {
		this.col = input_col;
		this.row = input_row;
	}
	
}
