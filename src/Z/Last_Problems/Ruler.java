package Z.Last_Problems;import java.util.Scanner;


public class Ruler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();		
		
		int caseSet[] = new int[]{64,32,16,8,4,2,1};
		
		int count=0;
		int sum=0; 
		for(int i=0;i<caseSet.length;i++)
		{
			int temp=0;
			if(caseSet[i] < X)
			{
				temp = caseSet[i];
				if((sum+temp)<=X)
				{
					count++;
					sum+=temp;
					if(sum == X)
					{
						System.out.println(count);
						return;
					}
				}
			}
			if(caseSet[i] == X)
			{
				System.out.println("1");
			}
		}
		
	}
}
