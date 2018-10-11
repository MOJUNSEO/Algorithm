package Last_Problems;import java.util.Scanner;


public class TDSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		int cycle;
		
		row = sc.nextInt();
		col = sc.nextInt();
		
		System.out.println(row);
		System.out.println(col);
		
		int arr[][] = new int[col][row];
		
		
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				arr[i][j] = sc.nextInt();
			}			
		}
	
		cycle = sc.nextInt();
		
		int sum[] = new int[cycle];
		
		for(int i=0; i<cycle; i++)
		{
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int result=0;
			
			for(int a=y1; a<col;a++)
			{
				for(int b=x1; b<row;b++)
				{
					result = arr[y1][x1] + arr[y1][y2];
				}
			}
		}
		
		
		
	}
}
