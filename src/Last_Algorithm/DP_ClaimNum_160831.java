/*
/����
������ ���� ���� �ڸ��� ���������� �̷�� ���� ���Ѵ�. �� ��, ������ ���� ���Ƶ� ������������ ģ��.

���� ���, 2234�� 3678, 11119�� ������ ��������, 2232, 3676, 91111�� ������ ���� �ƴϴ�.

���� ���� N�� �־����� ��, ������ ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� 0���� ������ �� �ִ�.

/�Է�
ù° �ٿ� N (1 �� N �� 1,000)�� �־�����.

/���
ù° �ٿ� ���̰� N�� ������ ���� ������ 10,007�� ���� �������� ����Ѵ�.

/���� �Է�  ����
1
���� ���  ����
10
���� �Է� 2  ����
2
���� ��� 2  ����
55
���� �Է� 3  ����
3
���� ��� 3  ����
220
*/
package Last_Algorithm;import java.util.Scanner;


public class DP_ClaimNum_160831 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int D[][] = new int [N][10];
		
		for(int i=0;i<10;i++)
		{
			D[0][i] = 1;
		}
		
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<10;j++)
			{
				for(int k=j;k<10;k++)
				{
					D[i][j] = (D[i][j] + D[i-1][k])%10007;
				}
			}
		}
		int temp =0;
		for(int i=0;i<10;i++)
		{
			temp = (temp + D[N-1][i])%10007;
		}
		System.out.println(temp);
	}
}
