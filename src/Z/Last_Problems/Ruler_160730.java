/*
����/
�����̴� ���̰� 64cm�� ���븦 ������ �ִ�. 
�����, �״� ���̰� Xcm�� ���밡 ������ �;�����. 
�����̴� ���� ������ �ִ� ���븦 �� ���� ����� �ڸ�������, Ǯ�� �ٿ��� ���̰� Xcm�� ���븦 ������� �Ѵ�.
���븦 �ڸ��� ���� ���� ����� �������� �ڸ��� ���̴�. 
�����̴� �Ʒ��� ���� ������ ���ļ� ���븦 �ڸ����� �Ѵ�.
�����̰� ������ �ִ� ������ ���̸� ��� ���Ѵ�. 
ó������ 64cm ���� �ϳ��� ������ �ִ�. 
�� ��, ���� X���� ũ�ٸ�, �Ʒ��� ���� ������ �ݺ��Ѵ�.
������ �ִ� ���� �� ���̰� ���� ª�� ���� �������� �ڸ���.
����, ������ �ڸ� ������ ���� �� �ϳ��� ������ �����ִ� ������ ������ ���� X���� ũ�ų� ���ٸ�, 
������ �ڸ� ������ ���� �� �ϳ��� ������.
����, �����ִ� ��� ���븦 Ǯ�� �ٿ��� Xcm�� �����.
X�� �־����� ��, ���� ������ ��ģ�ٸ�, �� ���� ���븦 Ǯ�� �ٿ��� Xcm�� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�/
ù° �ٿ� X�� �־�����. X�� 64���� �۰ų� ���� �ڿ����̴�.

���/
23 -> 4
32 -> 1
64 -> 1
48 -> 2
*/
package Z.Last_Problems;
import java.util.Scanner;
public class Ruler_160730 {
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
