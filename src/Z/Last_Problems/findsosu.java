package Z.Last_Problems;import java.util.Scanner;


public class findsosu {
	public static void main(String[] args) {
		int N;
		int count=0;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i] = sc.nextInt();
		}	
		
		for(int i=0;i<N;i++)
		{
			if(arr[i] <= 5)
			{
				if(arr[i] == 2)
				{
					count++;
				}
				else if(arr[i] == 3)
				{
					count++;
				}
				else if(arr[i] == 5)
				{
					count++;
				}
			}
			else if((arr[i]%2!=0)&&(arr[i]%3!=0)&&(arr[i]%5!=0))
			{
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
