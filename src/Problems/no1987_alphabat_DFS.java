package Problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://www.acmicpc.net/problem/1987
 * 방문이 문제가 아니라, 방문여부 대신 전에 들렸던 알파벳이 무엇인지 
 * 기억시키는 것이 관건! 
 * 조건문이었다면 4-5줄 써야하는 것을 
 * max = max < count ? count : max; 한줄로 줄임.
 * */

public class no1987_alphabat_DFS {
	static int col = 0;
	static int row = 0;
	static String map[][];
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String value[] = in.readLine().split(" ");
		col = Integer.parseInt(value[0]);
		row = Integer.parseInt(value[1]);
		
		map = new String[col][row];
		
		//input
		for(int i=0;i<col;i++)
		{
			String temp[] = in.readLine().split("");
			for(int j=0;j<temp.length;j++)
			{
				map[i][j] = temp[j];
			}
		}
		int count = 0;
		ArrayList<String> list = new ArrayList<>();
		move_DFS(0,0,count,list);
		System.out.println(max);
	}
	
	static void move_DFS(int now_col, int now_row, int count, ArrayList<String> list)
	{
		//up down left right 
		int dcol[] = {-1,1,0,0};
		int drow[] = {0,0,-1,1};
		
		// 이전에 알파벳이라면 
		if(list.contains(map[now_col][now_row]) == true)
		{
			//max = max < count 가 참이면 count , 거짓이면 max 
			max = max < count ? count : max;
			return;
		}
		else
		{
			ArrayList<String> nextlist = new ArrayList<>();
			nextlist.addAll(list);
			nextlist.add(map[now_col][now_row]);
			++count;
			for(int i=0; i<4; i++)
			{
				//mask
				int tmp_col = now_col + dcol[i];
				int tmp_row = now_row + drow[i];
				//range
				if(tmp_col > -1 && tmp_col < col)
				{
					if(tmp_row > -1 && tmp_row < row)
					{
						move_DFS(tmp_col,tmp_row,count,nextlist);
					}
				}
			}
		}
	}
}
