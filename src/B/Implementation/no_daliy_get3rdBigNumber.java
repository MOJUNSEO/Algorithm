package B.Implementation;

import java.util.Scanner;

public class no_daliy_get3rdBigNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		Solution(arr);
		
		sc.close();
		return;
	}
	
	private static void Solution(int arr[])
	{
		int index = -1;
		
		for(int i=0;i<arr.length-1;i++)
		{
			index = i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[index] > arr[j])
				{
					index = j;
				}
			}
			if(index != i)
			{
				int temp = -1;
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
			index = -1;
		}
		System.out.println(arr[arr.length-3]);
		return;
	}
}
