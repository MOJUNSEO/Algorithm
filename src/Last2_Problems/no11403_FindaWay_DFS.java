package Last2_Problems;

import java.util.*;

//https://www.acmicpc.net/proListBlem/11403
public class no11403_FindaWay_DFS {
	static int Vertex;
	static int input[][];
	static int output[][];
	static int visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Vertex = sc.nextInt();		
		input = new int[Vertex][Vertex];
		output = new int[Vertex][Vertex];
		
		//인접행렬 입력받음 
		for(int i=0;i<Vertex;i++)
		{
			for(int j=0;j<Vertex;j++)
			{
				input[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		//각 각 정점마다 DFS실행 
		for(int i=0;i<Vertex;i++)
		{
			visit = new int[Vertex];
			DFS(i,true);
			output[i] = visit;
		}
		
		//결과 출력
		for(int i=0; i<Vertex;i++)
		{
			for(int j=0;j<Vertex;j++)
			{
				System.out.print(output[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static void DFS(int Vertex, boolean isfirst)
	{
//		if(visit[Vertex] == 1)
//		{
//			return;
//		}
		//visit[Vertex] = 1;
		//이거안하고 isfirst로 확인하는 이유
		//== DFS를 시작하는 시점에서 visit배열을 1로 바꿔주지않는 이유는 결국에 2번겹치기 때문 
		
		
		//!isfisrt  == isfirst == false
		if(isfirst == false)
		{
			visit[Vertex] = 1;
		}
		for(int i=0;i<input.length;i++)
		{
			if(input[Vertex][i] == 1 && visit[i] == 0)
			{
				DFS(i,false);
			}
		}
	}
}
