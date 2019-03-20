package Z.Last2_Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/13460
 * 조건이 너무 많음,, 머리 쌩쌩할 때 다시해야함 
 * */
public class try_no13460_zzeroexit2_prepSW {
	static int col;
	static int row;
	static char map[][];
	static int max_count = 10;
	static int now_count = 1;
	static int B_col;
	static int B_row;
	static int R_col;
	static int R_row;
	static int exit_col;
	static int exit_row;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		col = sc.nextInt();
		row = sc.nextInt();
		
		//check value in range
		if(col < 3 || row > 10)
		{
			return;
		}
		//init
		map = new char[col][row];
		
		for(int i=0;i<col;i++)
		{
			String temp = sc.next();
			for(int j=0;j<row;j++)
			{
				char c = temp.charAt(j);
				if(c == 'B')
				{
					B_col = i;
					B_row = j;
				}
				if(c == 'R')
				{
					R_col = i;
					R_row = j;
				}
				if(c == '0')
				{
					exit_col = i;
					exit_row = j;
				}
				map[i][j] = c;
			}
		}
		
		//check vaule in range
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				if(i==0 || i==col-1)
				{
					if(map[i][j] != '#')
					{
						return;
					}
				}
				if(j==0 || j==row-1)
				{
					if(map[i][j] != '#')
					{
						return;
					}
				}
			}
		}
		//max_count = (int)Math.pow(4, 10);
		//start Algorithm
		BFS();
		
		
		
		
		
	}
	public static void BFS()
	{
		Queue<char[][]> q = new LinkedList<char[][]>();
		q.add(map);
		
		while(!q.isEmpty())
		{
			int d_col[] = {1,-1,0,0};
			int d_row[] = {0,0,1,-1};
			
			char tempmap[][] = q.poll();
			//최대 반복수이면 종료 
			System.out.println("nowcount > " + now_count);
			System.out.println("maxcount > " + max_count);
			
			if(now_count == max_count)
			{
				return;
			}
			//빨간 구슬이동그라미 들어가면 종료 
			if(R_col == exit_col && R_row == exit_row)
			{
				System.out.println("success > " + now_count);
				return;
			}
			//파란 구슬이 동그라미에 들어가면 종료 
			if(B_col == exit_col && B_row == exit_row)
			{
				System.out.println("fail > " + now_count);
				return;
			}
			now_count++;
			for(int i=0;i<4;i++)
			{
				// 0 > up
				// 1 > down
				// 2 > right
				// 3 > left			
				int next_R_col = R_col + d_col[i];
				int next_R_row = R_row + d_row[i];
				int next_B_col = B_col + d_col[i];
				int next_B_row = B_row + d_row[i];
				if(next_R_col > 0 && next_R_col < col-1 && next_R_row > 0 && next_R_row < row)
				{
					if(next_B_col > 0 && next_R_col < col-1 && next_B_row > 0 && next_B_row < row)
					{
						q.add(move(i,next_R_col,next_R_row,next_B_col,next_B_row,tempmap));	
					}
				}
			}
		}
	}
	
	public static char[][] move(int foward,int next_R_col,int next_R_row,int next_B_col,int next_B_row,char tempmap[][])
	{
		//조건 좌우상하의 값이 . < 이어야함
		//옆의 값이 0이면 이동시키고 종료 
		//0이고 지금 값이 R,B이면 이동 
		//up
		char returnmap[][] = tempmap;
		if(foward == 0)
		{
			//check range in map
			if(B_col - 1 > 0 && R_col - 1 > 0)
			{
				//check value in map
				if(returnmap[B_col-1][B_row] == '.')
				{
					returnmap = swap(B_col-1,B_row,B_col,B_row,returnmap);
					B_col++;
				}
				if(returnmap[R_col-1][R_row] == '.')
				{
					returnmap = swap(R_col-1,R_row,R_col,R_row,returnmap);
					R_col++;
				}
			}
			printmap(returnmap);
			System.out.println();
		}
		//down
		else if(foward == 1)
		{
			
		}
		//right
		else if(foward == 2)
		{
			
		}
		//left
		else if(foward == 3)
		{
			
		}
		return returnmap;
	}
	
	public static char[][] swap(int index1_col, int index1_row, int index2_col, int index2_row, char returnmap[][])
	{
		char temp = returnmap[index1_col][index1_row];
		returnmap[index1_col][index1_row] = returnmap[index2_col][index2_row];
		returnmap[index2_col][index2_row] = temp;
		return returnmap;
	}
	
	public static void printmap(char[][] forprintmap)
	{
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				System.out.print(forprintmap[i][j]);
			}
			System.out.println();
		}
	}
}
