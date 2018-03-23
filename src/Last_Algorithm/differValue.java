package Last_Algorithm;import java.util.Scanner;


public class differValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[10];		
		
		int total=0;
		
		for(int i=0;i<10;i++)
		{
			arr[i] = sc.nextInt()%42;
		}		
		
		for(int j=0;j<10;j++)
		{
			for(int k=0;k<10;k++)
			{
				if((j != k)&&(arr[j] == arr[k]))
				{
					arr[k] = 50;
				}				
			}
		}
		
		for(int a=0;a<10;a++)
		{
			if(arr[a]!=50)
			{
				total++;
			}
		}
		System.out.println(total);
	}
}
