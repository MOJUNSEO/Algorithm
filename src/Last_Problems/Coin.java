package Last_Problems;import java.util.Scanner;


public class Coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case=sc.nextInt();
		if(Case >= 10)
		{
			return;
		}
		int N[][] = new int[Case+1][7];
		N[0][0] = 1;
		N[0][1] = 5;
		N[0][2] = 10;
		N[0][3] = 50;
		N[0][4] = 100;
		N[0][5] = 500;
		
		int D[] = new int[Case];
		
		for(int i=1;i<Case+1;i++)
		{
			int n=sc.nextInt();
			if(n >= 7)
			{
				return;
			}
			for(int j=0;j<n;j++)
			{
				N[i][j] = sc.nextInt();
			}
			int price=sc.nextInt();
			if(price > 10000)
			{
				return;
			}
			else
			{
				N[i][6] = price;
			}
		}
		
		for(int i=1;i<Case+1;i++)
		{			
			for(int point=5;point<0;point--)
			{				
				for(int a=N[i][point];a<0;a--)
				{
					int coin = N[i][6];
					if(a*N[0][a] > coin)
					{
						continue;
					}
					if(a*N[0][a] == coin)
					{
						D[i]++;
					}
					if(a*N[0][a] < coin)
					{
						coin = coin - a*N[0][a]; 
						for(int b=N[i][point-1];b<0;b--)
						{
							
						}
					}
				}
			}
		}
		
		/*
		for(int i=0;i<Case+1;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(N[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}
}
