package E.String;
import java.util.Scanner;

public class no1032_prompt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arrlength = 0;
		sc.nextLine();
		
		String arr[][] = new String[N][50];
		
		for(int i=0; i<N; i++)
		{
			String temp[] = sc.nextLine().split("");
			arrlength = temp.length;
			for(int j=0; j<temp.length; j++)
			{
				arr[i][j] = temp[j];
			}
		}
	

		Solution(arr,N,arrlength);
		
		sc.close();
	}
	
	static void Solution(String arr[][],int N,int len)
	{
		String result[] = arr[0].clone();
		for(int j=0;j<len;j++)
		{
			for(int i=0;i<N-1;i++)
			{
				if(arr[i][j].equals(arr[i+1][j]))
				{
					continue;
				}
				else
				{
					result[j] = "?";
				}
			}
		}
		
		for(String a : result)
		{
			if(a != null)
			{
				System.out.print(a);
			}
			
		}

		return;
	}
}
