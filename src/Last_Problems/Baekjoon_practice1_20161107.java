package Last_Problems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
���� �˰��� �ΰ� ù ���� �ǽ�
ArrayList�� ����Ͽ� �����ϱ�

�׷��� ����, ���� ����Ʈ ������ Ǯ �� ���� ����Ѵ�.
 */
public class Baekjoon_practice1_20161107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/* Ÿ���� Integer���� ArrayList�� ���� �� �ʱ�ȭ */
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			int temp = sc.nextInt();
			a.add(temp);
		}
		
		Collections.sort(a);
		for(int x:a)
		{
			System.out.println(x);
		}
		
	}
}
