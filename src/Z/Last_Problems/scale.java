package Z.Last_Problems;import java.util.Scanner;

public class scale {
	public static void main(String[] args) {
		/* ���� �Է½� �ߺ� �ȵǰ� �ϴ°� ����ó�� �ʿ� */
		/* �Է� ������ ���� ����ó�� �ʿ� */
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[8];		
		
		for(int i=0; i<8; i++)
		{
			arr[i] = sc.nextInt();			
		}
		
		if(arr[0] == 1)
		{
			for(int i=0;i<7;i++)
			{
				if(arr[i+1] != (arr[i]+1))
				{
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		}
		else if(arr[0] == 8)
		{
			for(int i=0;i<7;i++)
			{
				if(arr[i+1] != (arr[i]-1))
				{
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
		}
		else
		{
			System.out.println("mixed");
		}
	}
}
