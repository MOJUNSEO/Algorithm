package Last_Algorithm;import java.util.Scanner;

/*
����/
�������� N���� �����ϴ� ��Ÿ ��ʸ�Ʈ�� �����ߴ�. 
��ʸ�Ʈ�� ������ ���� ����ȴ�. 
�ϴ� N���� �����ڴ� ��ȣ�� 1������ N������ �����޴´�. 
�׷��� �� �Ŀ� ���� ������ ��ȣ���� ��Ÿ�� �Ѵ�. 
�̱� ����� ���� ���忡 �����ϰ�, �� ����� �� ���忡�� ��������. 
���� �� ������ �����ڰ� Ȧ�����̶��, ������ ��ȣ�� ���� �����ڴ� ���� ����� �ڵ� �����Ѵ�. 
���� ���忡�� �ٽ� �������� ��ȣ�� 1������ �ű��. �� ��, ��ȣ�� �ű�� ������ ó�� ��ȣ�� ������ �����ϸ鼭 1������ �ű��. �� ���� 1���� 2���� ��Ÿ�� �ؼ� 1���� �����ϰ�, 3���� 4���� ��Ÿ�� �ؼ� 4���� �����ߴٸ�, 4���� ���� ���忡�� ��ȣ 2���� �����޴´�. ��ȣ�� �ٽ� �������� �Ŀ� �� �� ���� ������ ���带 ��� �Ѵ�.
��ħ �� ��Ÿ ��ȸ�� ���Ѽ��� �����ߴ�. 
�������� ���ڱ� ��Ÿ ��ȸ���� ����ϴ� ����� ��������, �� ���忡�� ���Ѽ��� ����ϴ��� �ñ�������. 
�ϴ� �����ΰ� ���Ѽ��� ���� ����ϱ� ������ �׻� �̱�ٰ� �����Ѵ�. 
1 ���忡�� �������� ��ȣ�� ���Ѽ��� ��ȣ�� �־��� ��, 
���� �����ΰ� ���Ѽ��� �� ���忡�� ����ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�/
ù° �ٿ� �������� �� N�� 1 ���忡�� �������� ��ȣ�� ���Ѽ��� ��ȣ�� ������� �־�����. 
N�� 100,000���� �۰ų� ���� �ڿ����̰�, �������� ��ȣ�� ���Ѽ��� ��ȣ�� N���� �۰ų� ���� �ڿ����̰�, ���� �ٸ���.
*/
public class Tournament_160730 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int participant = sc.nextInt();
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		
		int tournament[] = new int[participant];
		
		for(int i=0;i<tournament.length;i++)
		{
			tournament[i] = i+1;
			System.out.println("tournament "+i+"��° ����"+ tournament[i]);
		}
		
		int cursor=0;
		int temp1=0;
		int temp2=0;
		int round=1;
		while(participant != 1)
		{
			System.out.println("round/"+(round+1));
			System.out.println("cursor/"+cursor);
			if(cursor >= tournament.length)
			{
				round++;
				cursor =0;
				temp1=0;
				temp2=0;
			}
			else
			{
				if(tournament[cursor]!=0)
				{
					if(temp1==0)
					{
						temp1 = tournament[cursor];
						cursor++;
					}
					else if(temp1 !=0 && temp2 ==0)
					{
						temp2 = tournament[cursor];
						if(temp1==number1 || temp1==number2)
						{
							if(temp2==number1||temp2==number2)
							{
								System.out.println("���� round : "+round);
								System.out.println(round);
								return;
							}
							else
							{
								tournament[(temp2-1)] = 0;
								temp1 = 0;
								temp2 = 0;
								cursor++;
							}
						}
						else
						{
							if(temp2==number1||temp2==number2)
							{
								tournament[(temp1-1)] = 0;
								temp1 = 0;
								temp2 = 0;
								cursor++;
							}
							else
							{
								tournament[temp2-1] = 0;
								temp1 = 0;
								temp2 = 0;
								cursor++;
							}
						}
					}
				}
				else
				{
					cursor++;
					System.out.println("cursor���� "+cursor);
				}
			}
		}
	}

}
