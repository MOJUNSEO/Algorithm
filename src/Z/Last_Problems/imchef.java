package Z.Last_Problems;import java.util.Scanner;


public class imchef {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int[5][4];
		int winner=0;
		int result=0;
		for(int i=0; i<5; i++)
		{
			int temp = 0;
			for(int j=0; j<4; j++)
			{
				arr[i][j] = sc.nextInt();
				temp += arr[i][j];
			}
			if(temp > result)
			{
				result = temp;
				winner = i;
			}
		}
		
		System.out.println(winner+1 + " " + result);
		
	}
}
