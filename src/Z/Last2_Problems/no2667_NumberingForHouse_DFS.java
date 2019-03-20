package Z.Last2_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/2667
 * 재귀버젼 / Stack 버전 둘 다 짜놓았
 * Stack 이던, Queue던 항상 다음 노드를 찾기위한 방법을 넘겨 주는것을 잊지말자 
 * */
public class no2667_NumberingForHouse_DFS {
	static int N;
	static int map[][];
	static int visit[][];
	static int house_count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				map[i][j] = 0;
				visit[i][j] = 0;
			}
		}
		
		for(int i=0; i<N; i++)
		{
			String temp = sc.next();
			for(int j=0; j<N; j++)
			{
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N;j++)
			{
				if(map[i][j] == 1 && visit[i][j] == 0)
				{
					house_count++;
					DFS_stack(i, j);
					//DFS_recrusion(i,j);
				}
			}
		}
		 
		System.out.println(house_count);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<house_count+1; i++)
		{
			list.add(counthouse(i,visit)); 
		}
		
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
		
		
		
	}
	
	public static void DFS_recrusion(int inputcol, int inputrow)
	{
		int d_col[] = {1,-1,0,0};
		int d_row[] = {0,0,1,-1};
		if(map[inputcol][inputrow] == 0 && visit[inputcol][inputrow] != 0)
		{
			return;
		}
	
		visit[inputcol][inputrow] = house_count;
		for(int i=0; i<4; i++)
		{
			int next_col = inputcol + d_col[i];
			int next_row = inputrow + d_row[i];
			//범위 확인 
			if(next_col >= 0 && next_col < N && next_row >=0 && next_row < N)
			{
				// 집이 있고, 그 집에 아직 방문하지 않은 건지 확인 
				if(map[next_col][next_row] == 1 && visit[next_col][next_row] == 0)
				{
					DFS_recrusion(next_col, next_row);
				}
			}
		}
	}
	
	public static void DFS_stack(int inputcol, int inputrow)
	{
		int d_col[] = {1,-1,0,0};
		int d_row[] = {0,0,1,-1};
		
		Stack<Integer> s = new Stack<Integer>();
		s.add(inputcol);
		s.add(inputrow);
		
		while(!s.isEmpty())
		{
			int poprow = s.pop();
			int popcol = s.pop();
			System.out.println("popcol/poprow="+popcol+","+poprow);
			if(map[popcol][poprow] == 0 && visit[popcol][poprow] != 0)
			{
				return;
			}
			System.out.println("house_count" + house_count);
			visit[popcol][poprow] = house_count;
			for(int i=0; i<4; i++)
			{
				int next_col = popcol + d_col[i];
				int next_row = poprow + d_row[i];
				//범위 확인 
				if(next_col >= 0 && next_col < N && next_row >=0 && next_row < N)
				{
					// 집이 있고, 그 집에 아직 방문하지 않은 건지 확인 
					if(map[next_col][next_row] == 1 && visit[next_col][next_row] == 0)
					{
						s.add(next_col);
						s.add(next_row);
					}
				}
			}
		}
		
	}
	
	public static int counthouse(int house_number,int countingArr[][])
	{
		int count = 0;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(countingArr[i][j] == house_number)
				{
					count+=1;
				}
			}
		}
		return count;
	}
	
	public static void printmap(int arr[][])
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
