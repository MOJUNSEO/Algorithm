package Z.Last2_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/7576
 * Buffered in/out stream 사용과 전체 반복문이 아닌 필요한것만 큐에 넣는 것에 의의.
 * ' 턴 개념 ' 
 * 정확한 알고리즘 이해 할 것 
 * */
public class no7576_Tomato_BFS {
	static int col;
	static int row;
	static int map[][];
	static boolean allripen = true;
	//static int visit[][];
	
	//http://blog.naver.com/PostView.nhn?blogId=itkmj&logNo=220606047245&parentCategoryNo=&categoryNo=13&viewDate=&isShowPopularPosts=false&from=postView
	//턴제 / 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Elements> list = new LinkedList<>();
		
		String line[] = in.readLine().split(" ");
		row = Integer.parseInt(line[0]);
		col = Integer.parseInt(line[1]);
		
		map = new int[col][row];
		//visit = new int[col][row];
		
		for(int c = 0; c < col ; c++)
		{
			String temp[] = in.readLine().split(" "); 
			for(int r = 0; r < row ; r++)
			{
				map[c][r] = Integer.parseInt(temp[r]);
				//토마토가 있는 부분만 저장 
				if(map[c][r]== 1)
				{
					list.add(new Elements(c, r));
				}
				if(map[c][r] == 0)
				{
					allripen = false;
				}
			}
		}
		
		//토마토가 있는 부분에서만 BFS진행 -> 전체 반복문을 피함으로써 효율적 
		//상향식 For문 
		for(Elements e : list)
		{
			BFS(e.col,e.row);
		}
		
		System.out.println(getDay());
		

		
	}
	
	//어디에서 토마토를 익히는것이 제일 빠른지 BFS를 통해 측정(시작점)  
	static void BFS(int now_col, int now_row)
	{
		// up , down, right, left 
		int dist_col[] = {-1,1,0,0};
		int dist_row[] = {0,0,1,-1};
		
		Queue<Elements> q = new LinkedList<>();
		q.offer(new Elements(now_col, now_row));
		
		while(!q.isEmpty())
		{
			int q_col = q.peek().col;
			int q_row = q.poll().row;
			for(int i=0; i < 4 ; i++)
			{
				int n_col = q_col + dist_col[i];
				int n_row = q_row + dist_row[i];
				
				//check about range
				if(n_col >= 0 && n_col < col)
				{
					if(n_row >= 0 && n_row < row)
					{
						if(map[n_col][n_row] == 0 || (map[q_col][q_row] + 1 < map[n_col][n_row]))
						{
							map[n_col][n_row] = map[q_col][q_row] + 1;
							q.offer(new Elements(n_col,n_row));
						}
					}
				}
			}	
		}	
	}
	
	static int getDay()
	{
		boolean notyetripen = true;
		int day = 0;
		if(allripen == true)
		{
			return 0;
		}
		for(int c = 0; c < col ; c++)
		{
			for(int r = 0; r < row ; r++)
			{
				int temp = map[c][r];
				if(temp == 0)
				{
					return -1;
				}
				if(temp > day)
				{
					day = temp;
				}
			}
		}
		return day-1;
	}
	
}

class Elements{
	int col, row;
	
	public Elements(int c,int r)
	{
		this.col = c;
		this.row = r;
	}
}
