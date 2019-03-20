package Prep.kakakoProblems;
import java.util.Scanner;

public class kk1_secretmap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			arr2[i] = sc.nextInt();
		}
		
		String result[] = solution(n, arr1, arr2);
		for(String a : result)
		{
			if(a == null)
			{
				System.out.println("fail");
				return;
			}
			System.out.println(a);
		}
		
	}
	
	static private String[] solution(int n, int arr1[], int arr2[])
	{
		String resultArr[] = new String[n];
		if(n > 16 || n < 1)
		{
			return null;
		}
		
		for(int i=0;i<n;i++)
		{
			String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
			temp = String.format("%"+n+"s",temp);
			temp = temp.replaceAll("1", "#");
			temp = temp.replaceAll("0", " ");
			resultArr[i] = temp;
		}
		
		return resultArr;
	}
}
