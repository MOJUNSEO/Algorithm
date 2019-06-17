package Z1.Last2_Problems;
/*
 * https://www.acmicpc.net/problem/12100
 * 2048게임 재도전 백트레킹(BFS or DFS사용해야 할 듯)
 * 실패 떴음!!!!!
 * 한 번의 명령에서 합쳐진 블록은 다른 블록과 합쳐질수없다. < 유의해서 다시 고민해볼 것!
 * */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class try_no12100_BoardGame_prepSW {
	static int N;
	static int map[][];
	static int count=0;
	static int now_count=0;
	static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		//input data to map
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int x = sc.nextInt();
				boolean check = false;
				//check range
				if(x < 2 && x > 1024)
				{
					System.out.println("exit");
					return;
				}
				//check 2^x
				for(int k=1; k<11;k++)
				{
					int comtemp = (int)Math.pow(2, k); 
					if(comtemp == x)
					{
						check = true;
					}
				}
				if(x == 0)
				{
					check = true;
				}
				if(check == false)
				{
					System.out.println("exit");
					return;
				}
				map[i][j] = x;
			}
		}
		
		// cycle > each up, down, left, right마다 4번씩 진행, 최대 5번까지 
		count = (int)Math.pow(4, 5);
		
		search(map);
	}
	
	//DFS using stack
	public static void search(int map[][])
	{
		//0 > up 1 > down 2 > right 3 > left
		int mask[] = {0,1,2,3};
		Queue<int[][]> q = new LinkedList<int[][]>();
		
		q.add(map);

		while(q.isEmpty() == false)
		{
			if(count == now_count)
			{
				System.out.println(max);
				return;
			}
			int domap[][] = q.poll();
			for(int i=0;i<4;i++)
			{
				int tempmap[][] = move(domap,i);
				for(int v=0;v<domap.length;v++)
				{
					for(int j=0;j<domap.length;j++)
					{
						System.out.print(tempmap[v][j]);
					}
					System.out.println();
				}
				System.out.println("--");
				q.add(tempmap);
				now_count++;
			}
		}
	}
	
	public static int [][] move(int tempmap[][], int forward)
	{
		int returnmap[][] = tempmap;
		//어떤 방향으로 밀 때, 앞에 같은 것이면 더하고 당기고!, 0이면 그냥 당기고!
		//up
		if(forward == 0)
		{
			//맨 윗줄을 할 필요 없다 (범위확인) 
			for(int i=returnmap.length-1;i>0;i--)
			{
				for(int j=0;j<returnmap.length;j++)
				{
					//위 값이 같으면 
					if(returnmap[i-1][j] == returnmap[i][j])
					{
						//합치고 
						returnmap[i-1][j] = returnmap[i-1][j] + returnmap[i][j];
						returnmap[i][j] = 0;
						//당겨라 어디까지 > 검사하고 있는 행부터 끝까지, 미는 방향의 반대로 당겨온다  
						for(int a = i;a<returnmap.length;a++)
						{
							if(a == returnmap.length-1)
							{
								returnmap[a][j] = 0;
							}
							else if(a < returnmap.length-1)
							{
								returnmap[a][j] = returnmap[a+1][j];
							}
						}
					}
					//위 값이 0이면
					if(returnmap[i-1][j] == 0)
					{
						returnmap[i-1][j] = returnmap[i][j];
						for(int a = i;a<tempmap.length;a++)
						{
							if(a == returnmap.length-1)
							{
								returnmap[a][j] = 0;
							}
							else if(a < returnmap.length-1)
							{
								returnmap[a][j] = returnmap[a+1][j];
							}
						}
					}
				}
			}
			findmax(returnmap);
		}
		//down
		else if(forward == 1)
		{
			//맨 아랫줄을 할 필요 없다 (범위확인) 
			for(int i=0;i<returnmap.length-1;i++)
			{
				for(int j=0;j<returnmap.length;j++)
				{
					//아래 값이 같으면 
					if(returnmap[i+1][j] == returnmap[i][j])
					{
						//합치고 
						returnmap[i+1][j] = returnmap[i+1][j] + returnmap[i][j];
						returnmap[i][j] = 0;
						//당겨라 어디까지 > 검사하고 있는 행부터 끝까지, 미는 방향의 반대로 당겨온다  
						for(int a = i;a >= 0;a--)
						{
							if(a == 0)
							{
								returnmap[a][j] = 0;
							}
							else if(a > 0)
							{
								returnmap[a][j] = returnmap[a-1][j];
							}
						}
					}
					//아래 값이 0이면
					if(returnmap[i+1][j] == 0)
					{
						returnmap[i+1][j] = returnmap[i][j];
						for(int a = i; a >= 0;a--)
						{
							if(a == 0)
							{
								returnmap[a][j] = 0;
							}
							else if(a > 0)
							{
								returnmap[a][j] = returnmap[a-1][j];
							}
						}
					}
				}
			}
			findmax(returnmap);
		}
		//right
		else if(forward == 2)
		{
			//맨 오른쪽줄을 할 필요 없다 (범위확인) 
			for(int i=0;i<returnmap.length;i++)
			{
				for(int j=0;j<returnmap.length-1;j++)
				{
					//오른쪽 값과 같으면  
					if(returnmap[i][j+1] == returnmap[i][j])
					{
						//합치고 
						returnmap[i][j+1] = returnmap[i][j+1] + returnmap[i][j];
						returnmap[i][j] = 0;
						//당겨라 어디까지 > 검사하고 있는 행부터 끝까지, 미는 방향의 반대로 당겨온다  
						for(int a = j;a >= 0;a--)
						{
							if(a == 0)
							{
								returnmap[i][a] = 0;
							}
							else if(a > 0)
							{
								returnmap[i][a] = returnmap[i][a-1];
							}
						}
					}
					//오른쪽 값이 0이면
					if(returnmap[i][j+1] == 0)
					{
						returnmap[i][j+1] = returnmap[i][j];
						for(int a = j;a >=0 ;a--)
						{
							if(a == 0)
							{
								returnmap[i][a] = 0;
							}
							else if(a > 0)
							{
								returnmap[i][a] = returnmap[i][a-1];
							}
						}
					}
				}
			}
			findmax(returnmap);
		}
		//left
		else if(forward == 3)
		{
			//맨 왼쪽 줄을 할 필요 없다 (범위확인) 
			for(int i=0;i<returnmap.length;i++)
			{
				for(int j=returnmap.length-1; j > 0;j--)
				{
					//왼쪽 값과 같으면  
					if(returnmap[i][j-1] == returnmap[i][j])
					{
						//합치고 
						returnmap[i][j-1] = returnmap[i][j-1] + returnmap[i][j];
						returnmap[i][j] = 0;
						//당겨라 어디까지 > 검사하고 있는 행부터 끝까지, 미는 방향의 반대로 당겨온다  
						for(int a = j;a < returnmap.length;a++)
						{
							if(a == returnmap.length-1)
							{
								returnmap[i][a] = 0;
							}
							else if(a < returnmap.length-1)
							{
								returnmap[i][a] = returnmap[i][a+1];
							}
						}
					}
					//왼쪽 값이 0이면
					if(returnmap[i][j-1] == 0)
					{
						returnmap[i][j-1] = returnmap[i][j];
						for(int a = j;a < returnmap.length;a++)
						{
							if(a == returnmap.length-1)
							{
								returnmap[i][a] = 0;
							}
							else if(a < returnmap.length-1)
							{
								returnmap[i][a] = returnmap[i][a+1];
							}
						}
					}
				}
			findmax(returnmap);
			}
		}
		return returnmap;
	}
	
	public static void findmax(int tempmap[][])
	{
		for(int i=0;i<tempmap.length;i++)
		{
			for(int j=0;j<tempmap.length;j++)
			{
				int x = tempmap[i][j];
				if(x > max)
				{
					max = x;
				}
			}
		}
	}
}
