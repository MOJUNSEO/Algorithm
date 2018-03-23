package Last_Algorithm;import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * �켱������ ���� �ͺ���pop
 * �ִ� Heap ����Ǯ��
 * 
 * PriorityQueue�� ���������� ó���ϴ� ���� �ƴϰ�, Ư�� �켱������ ť ó���� �����Ѵ�.
 * �켱 ������ ������ ������ �� �ְ�, ���� �������� ���� ��� ���ڿ��� ��� ������, ������ ���� ������������ ���ĵȴ�.
 * push : offer
 * pop : poll
 * front : peek
 */

public class Baekjoon_practice3_priorityQueue {
	static class Compare implements Comparator<Integer>
	{
		public int compare(Integer one, Integer two)
		{
			return two.compareTo(one);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Compare cmp = new Compare();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1,cmp);
		int n = sc.nextInt();
		while(n-->0)
		{
			int x = sc.nextInt();
			if(x == 0)
			{
				//ť�� ����ִٸ�
				if(q.isEmpty())
				{
					System.out.println(0);
				}
				else
				{
					System.out.println(q.poll());
				}
			}
			else
			{
				q.offer(x);
			}
		}
	}
}
