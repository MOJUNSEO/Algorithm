package Z.Last_Problems;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * Hashset, Treeset
 * �Ϲ������� Hashset(������ �߿����� �������)
 * Treeset(������ �߿��� ���)
 * LinkedHashset(�Է� ������ �߿��� ���)
 * */
public class no10815_numbercard_161107 {
	public static void main(String[] args) throws IOException{
/*		HashSet<Integer> d = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		 ���������� ī���� �� �� 
		int input = sc.nextInt();
		String result ="";
		 1,ī���� ���� �Է¹��� 
		for(int i=0;i<input;i++)
		{
			d.add(sc.nextInt());
		}
		
		 Hashset�� ������� �ʴٸ�
		 2,Ȯ���� ī�带 �Է¹��� 
		int check = sc.nextInt();
		for(int i=0;i<check;i++)
		{
			int getnum = sc.nextInt();
			if(d.contains(getnum))
			{
				result += "1";
			}
			else
			{
				result += "0";
			}
			result += " ";
		}
		System.out.println(result);*/
		/* ���� ���� �Ѵٸ� �ð� �ʰ� �߻� */
		//Scanner�� ���Ͽ��� �� �ð� ����
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		/* �� ī���� ��, ù ��° ��*/
		int n = Integer.parseInt(bf.readLine());
		/* ī�忡 �Էµ� ��, �� ��° �� */
		StringTokenizer st = new StringTokenizer(bf.readLine());
		HashSet<Integer> d = new HashSet<Integer>();
		while(st.hasMoreTokens())
		{
			int temp = Integer.parseInt(st.nextToken()); 
			d.add(temp);
		}
		
		/* Ȯ���ؾ��� ī�� ��, �� ��° �� */
		st = new StringTokenizer(bf.readLine());
		//String >> StringBuffer >> StringBuilder �ӵ� ��
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens())
		{
			int temp = Integer.parseInt(st.nextToken());
			if(d.contains(temp)) //Hashset�� �ִ��� ������ �˻��ϴ� �޼ҵ�
			{
				sb.append("1 ");
			}
			else
			{
				sb.append("0 ");
			}
			
		}
		System.out.println(sb);
		
	}

}
