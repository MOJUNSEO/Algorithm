package Prep_SMaestro_problems;

import java.util.Scanner;

// 선택정렬  / 오름차순 정렬하기(정확히 기억안남) 

public class problem3 {
	final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int Counts = sc.nextInt();
		
		int arr[] = new int[Counts];
		for(int i = 0; i < Counts ; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		
		System.out.println("허용 배열 범위 min / max : " + "0 / "+ (Counts-1));
		int from = sc.nextInt();
		if(from < 0 || from > arr.length-2)
		{
			System.out.println("배열 범위 확인 ");
		}
		int end = sc.nextInt();
		if(end <= from || end > arr.length-1)
		{
			System.out.println("배열 범위 확인 ");
		}
		selectsort_up(arr, from, end);
		for(int i : arr)
		{
			System.out.println(i);
		}
		upsort(arr, from, end);
		for(int i : arr)
		{
			System.out.println(i);
		}
		
	}
	
	//선택 정렬 오름차순 
	private static void selectsort_up(int arr[], int from, int end)
	{
		for(int i = from ; i <= end ; i++)
		{	
			for(int j = (i+1); j <= end; j++)
			{
				if(arr[i] >= arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
	
	//선택 정렬 내림차순 
	private static void upsort(int arr[], int from, int end)
	{
		for(int i = from ; i <= end ; i++)
		{	
			for(int j = (i+1); j <= end; j++)
			{
				if(arr[i] <= arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
