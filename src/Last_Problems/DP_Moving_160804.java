/*
/����
�رԴ� N��M ũ���� �̷ο� �����ִ�. 
�̷δ� 1��1ũ���� ������ �������� �ְ�, �� �濡�� ������ ������ �ִ�. 
�̷��� ���� ���� �� ���� (1, 1)�̰�, ���� ������ �Ʒ� ���� (N, M)�̴�.
�رԴ� ���� (1, 1)�� �ְ�, (N, M)���� �̵��Ϸ��� �Ѵ�. 
�ر԰� (i, j)�� ������, (i+1, j), (i, j+1), (i+1, j+1)�� �̵��� �� �ְ�, 
�� ���� �湮�� ������ �濡 �������ִ� ������ ��� ������ �� �ִ�. ��, �̷� ������ ���� ���� ����.
�ر԰� (N, M)���� �̵��� ��, ������ �� �ִ� ���� ������ �ִ밪�� ���Ͻÿ�.

/�Է�
ù° �ٿ� �̷��� ũ�� N, M�� �־�����. (1 �� N, M �� 1,000)
��° �ٺ��� N�� �ٿ��� �� M���� ���ڰ� �־�����, i��° ���� j��° ���ڴ� (i, j)�� ������ �ִ� ������ �����̴�. 
������ ������ 0���� ũ�ų� ����, 100���� �۰ų� ����.

/���
ù° �ٿ� �ر԰� (N, M)���� �̵��� ��, ������ �� �ִ� ���� ������ ����Ѵ�.
 */
package Last_Problems;
import java.util.Scanner;

public class DP_Moving_160804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		int row = sc.nextInt();
		int D[][] = new int[col][row];
		int map[][] = new int[col][row];
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		D[0][0] = map[0][0];
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				if(i==0 && j==0)
				{
					continue;
				}
				else
				{
					int temp0=0;
					int temp1=0;
					int temp2=0;
					if(i-1>=0) //i+1,j
					{
						temp0 = map[i][j] + D[i-1][j]; 
					}
					if(i-1>=0 && j-1>=0) //i+1,j+1 
					{
						temp1 = map[i][j] + D[i-1][j-1]; 
					}
					if(j-1>=0) //i,j+1
					{
						temp2 = map[i][j] + D[i][j-1];
					}
					D[i][j] = max(temp0,temp1,temp2);
					//System.out.println("i,j / "+i+","+j);
					//System.out.println(D[i][j]+"�ԷµǾ���");
				}				
			}
		}
		System.out.println(D[col-1][row-1]);
	}
	public static int max(int a, int b, int c)
	{
		int max=0;
		if(a >= b)
		{
			max = a;
		}
		if(b >= a)
		{
			max = b;
		}
		if(c >= max)
		{
			max = c;
		}
		return max;
	}
}

