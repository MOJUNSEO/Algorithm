package Z.Last_Problems;import java.util.Scanner;


public class Numtriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int triangle[][] =  new int[N][N];
		int D[][] = new int[N][(N-1)*2];

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<i+1;j++)
			{
				triangle[i][j] = sc.nextInt();
			}
		}
		D[0][0] = triangle[0][0];
		for(int i=0;i<N-1;i++)
		{
			int point=0;
			for(int j=0;j<i+1;j++)
			{
				D[i+1][point] = D[i][j] + triangle[i+1][j];
				D[i+1][point+1] = D[i][j] + triangle[i+1][j+1];
				point += 2;
			}
			point = 0;
		}

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<(N-1)*2;j++)
			{
				System.out.print(D[i][j]+" ");
			}
			System.out.println(" ");
		}
		int max = 0;
		for(int i=0;i<(N-1)*2;i++)
		{	
			max = Math.max(max, D[N-1][i]);
		}
		System.out.println(max);
		
		/*
		 import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, n=sc.nextInt(), max = 0, d[][] = new int[n+1][n+1];
		for (i = 1; i <= n; i++)
			for (j = 1; j <= i; j++) {
				d[i][j] = sc.nextInt();
				if (j == 1) d[i][j] = d[i - 1][j] + d[i][j];
				else if (j == i) d[i][j] = d[i - 1][j - 1] + d[i][j];
				else d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + d[i][j];
				if (max < d[i][j]) max = d[i][j];
			}
		System.out.println(max);
		sc.close();
	}
}

		 * 
		 */

	}
}
