/*
 * 49%
����/
RGB�Ÿ��� ��� ������� ���� ����, �ʷ�, �Ķ��߿� �ϳ��� ĥ�Ϸ��� �Ѵ�. 
����, �׵��� ��� �̿��� ���� ������ ĥ�� �� ���ٴ� ��Ģ�� ���ߴ�. 
�� i�� �̿��� �� i-1�� �� i+1�̴�. 
ó�� ���� ������ ���� �̿��� �ƴϴ�.
�� ���� �������� ĥ�� �� ��� ���, �ʷ����� ĥ�� �� ��� ���, �Ķ����� ��� ����� �־��� ��, 
��� ���� ĥ�� �� ��� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�/
ù° �ٿ� ���� �� N�� �־�����. 
N�� 1,000���� �۰ų� ����. 
��° �ٺ��� N���� �ٿ� �� ���� �������� ĥ�� ��, �ʷ����� ĥ�� ��, �Ķ����� ĥ�� �� ��� ����� �־�����.
	
���/
ù° �ٿ� ��� ���� ĥ�� �� ��� ����� �ּڰ��� ����Ѵ�.

�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�DP������ ��������ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
DP�� �̿��Ͽ�, R,G,B�� ������������ �����ּҰ��� ���ϰ�, ���ߴ� ���� �̿��� �������� ���Ѵ�!
*/

package Z.Last_Problems;

import java.util.Scanner;

public class DP_RGBcolor_160809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int house = sc.nextInt();
		
		int color[][] = new int[house][3];
		
		int D[][] = new int[house][3];
		
		for(int i=0;i<house;i++)
		{
			for(int j=0;j<3;j++)
			{
				color[i][j] = sc.nextInt();
			}
		}

		D[0][0] = color[0][0];
		D[0][1] = color[0][1];
		D[0][2] = color[0][2];
		
		for(int i=1;i<house;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(j==0)
				{
					D[i][j] = Math.min(D[i-1][j+1], D[i-1][j+2]) + color[i][j];
				}
				if(j==1)
				{
					D[i][j] = Math.min(D[i-1][j-1], D[i-1][j+1]) + color[i][j];
				}
				if(j==2)
				{
					D[i][j] = Math.min(D[i-1][j-1], D[i-1][j-2]) + color[i][j];
				}
			}
		}
		System.out.println(Math.min(Math.min(D[house-1][0], D[house-1][1]), D[house-1][2]));
		
	}
	
}
