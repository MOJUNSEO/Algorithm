package Last_Problems;import java.util.Scanner;


public class UphillRoad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int arr[] = new int[size];		
		
		int start=0;
		int end=0;
		int mid=0;
		int total = 0; //���� ū �������� ����
		int temp = 0; // ���� �������� ����
		
		for(int i=0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		for(int k=0;k<size;k++)
		{
			if(k == 0)
			{
				start = arr[k];
				end = arr[k];
			}
			else
			{
				mid = arr[k];
				if(end < mid)
				{
					end = mid;
					mid = 0;
					if(k == (size-1))
					{
						temp = end-start;
						if(temp > total)
						{
							total = temp;
						}
					}
				}
				else if(mid <= end)
				{
					temp = end - start;
					if(temp > total)
					{
						total = temp;
					}
					start = arr[k];
					end = start;
				}
			}	
		}
		if(total == 0)
		{
			System.out.println(total);
		}
		else
		{
			System.out.println(total);
		}
	}
}
