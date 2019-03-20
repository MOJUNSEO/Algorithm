package Z.Last_Problems;import java.util.Scanner;


public class no2750_Numsort_160926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		while(count != N-1)
		{
			for(int i=0;i<N-1;i++)
			{
				if(arr[i] < arr[i+1])
				{
					count++;
				}
				else if(arr[i] > arr[i+1])
				{
					int temp=0;
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					count = 0;
					break;
				}
			}
		}
		
		for(int i=0;i<N;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
