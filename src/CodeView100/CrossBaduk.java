package CodeView100;

import java.util.Scanner;

public class CrossBaduk {
	
	static int input[][] = new int[19][19];
	static int N = 0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<19; i++)
		{
			String temp[] = sc.nextLine().split(" ");
			for(int j=0;j<19;j++)
			{
				input[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		N = sc.nextInt();
		if(N > 10) {
			return;
		}
		for(int i=0; i<N; i++)
		{
			int col = sc.nextInt();
			int row = sc.nextInt();
			
			solution(col,row);
		}
		
		sc.close();
		
		for(int i=0;i<19;i++)
		{
			for(int j=0;j<19;j++)
			{
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
		return;
	}
	
	static public void solution(int col, int row) {
		
		for(int i=0;i<19;i++)
		{
			int col_temp = input[col-1][i];
			if(col_temp == 1) {
				input[col-1][i] = 0;
			}
			else
			{
				input[col-1][i] = 1;
			}
			int row_temp = input[i][row-1];
			if(row_temp == 1) {
				input[i][row-1] = 0;
			}
			else
			{
				input[i][row-1] = 1;
			}
		}
//		if(input[col-1][row-1] == 1) {
//			input[col-1][row-1] = 0;
//		}
//		else
//		{
//			input[col-1][row-1] = 1;
//		}
		return;
	}
}
