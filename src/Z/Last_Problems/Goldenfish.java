package Z.Last_Problems;import java.util.Scanner;

/*2016.07.19*/
/*11052-�ؾ�Ǹ��ϱ�*/
public class Goldenfish {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Fish = sc.nextInt();
		
		int FishSet[] = new int[Fish];
		
		/*�ִ� ���� ����*/
		int Maxprofit=0;
		
		/*�ʱ�ȭ*/
		for(int i=0;i<FishSet.length;i++)
		{
			FishSet[i] = 0;
		}
		
		/* �ؾ ��Ʈ ���� ����*/
		for(int i=0;i<FishSet.length;i++)
		{
			FishSet[i] = sc.nextInt();
		}
		
		/* �ؾ ��Ʈ �Է� ���� �� ���� �� ����ó�� */
		if(FishSet[Fish-1] == 0)
		{
			System.out.println("���� ������ �Է��ϼ���.");
			return;
		}
		
		/* �ؾ ��Ʈ ���� ���� ����*/
		for(int fi=1;fi<=Fish;fi++)
		{
			/* ���� �ؾ����*/
			int Tempprofit=0;
			Tempprofit += FishSet[fi]; // 1����Ʈ���ݴ�����
			int Leftfish = Fish-fi; // ���� �ؾ ���� 
			int d;
			if(Leftfish > 0) // �ؾ����������
			{
				//�����͸�ŭ �����Ѵ�
				for(int fj=fi;fj>0;fj--)
				{
					// ������ 2��, ���� ��Ʈ2����� �� ���� 0�̹Ƿ� ��
					// ������ ������ 2����, 3�������ϸ� �����ϸ�ȵ�
					// �׷��Ƿ� �����ſ��� ���� �ؾ��Ʈ�� �P���� 0�̻��̾���t 
					if(Leftfish-fj >= 0)
					{
						// �ؾ���������� ���ݴ�����
						Tempprofit += FishSet[fj];
						 //������ �ؾ��Ʈ�� �ؾ���� ����
						Leftfish -= fj;						
					}
				}
			}
			
			
		}
	}
}
