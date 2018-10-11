package Last_Problems;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class no1764_Map_161107 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		//�赵 ���� �ΰ�
		int l = Integer.parseInt(line[0]);
		//���� ���� �ΰ�
		int s = Integer.parseInt(line[1]);
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(int i=0;i<l;i++)
		{
			hm.put(br.readLine(),1);
		}
		
		for(int j=0;j<s;j++)
		{
			String temp = br.readLine();
			if(hm.containsKey(temp))
			{
				hm.put(temp, 3);
			}
			else
			{
				hm.put(temp,2);
			}
		}
		//�赵�������� ������ ������ ����Ʈ
		ArrayList<String> a = new ArrayList<String>();
		int count=0;
		//Map ��ü ��ȸ, HashMap�� ó������ ������ ��ü ��ȸ
		//Map <K,V> <ȫ�浿,1> �̷������� ����ȴ�. Key�� �ش��ϴ� Value�� ������ �ȴ�.
		for(Map.Entry<String,Integer> entry : hm.entrySet())
		{
			String rk = entry.getKey();
			int rv = entry.getValue();
			//�赵 ���� ���� �ΰ��̸� ArrayList�� �߰�
			if(rv == 3)
			{
				a.add(rk);
				count++;
			}
		}
		
		//���������� ����
		Collections.sort(a);
		
		//������� �� ������ �����͵��� �� ����
		System.out.println(a.size());
		for(String name:a)
		{
			System.out.println(name);
		}
	}
}
