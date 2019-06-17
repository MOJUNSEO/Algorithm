package Z1.Last2_Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no11403_FindaWay_BFS {
	static int Vertex;
	static int input[][];
	static int output[][];
	static int visit[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Vertex = sc.nextInt();
		input = new int[Vertex][Vertex];
		output = new int[Vertex][Vertex];
		
		for(int i=0;i<Vertex;i++)
		{
			for(int j=0;j<Vertex;j++)
			{
				input[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for(int i=0;i<Vertex;i++)
		{
			visit = new int[Vertex];
			BFS(i);
			output[i] = visit;
		}
		
		for(int i=0;i<Vertex;i++)
		{
			for(int j=0;j<Vertex;j++)
			{
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void BFS(int Vertex2)
	{
		Queue<Integer> q = new LinkedList();
		q.add(Vertex2);
		//visit[Vertex] = 1; 아래에서 방문배열을 수정하기 때문에 미리할필요가 없다
		
		while(q.isEmpty() == false)
		{
			int Qvertex = q.poll();
			//visit[Qvertex] = 1; 아래에서 방문배열을 수정하기 때문에 미리할필요가 없다 
			for(int i=0;i<input.length;i++)
			{
				if(input[Qvertex][i] == 1 && visit[i] == 0)
				{
					visit[i] = 1;
					q.add(i);
				}
			}
		}
		
	}
}
