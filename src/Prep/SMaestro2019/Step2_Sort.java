package Prep.SMaestro2019;

/**
 * 
 * 
 * @author jsmo
 *선택 정렬 
 *
 */
public class Step2_Sort {
	public static void main(String args[])
	{
		int arr[] = {8,5,2,6,9,3,1,4,0,7};
		
		selectsort(arr);
		System.out.println();
		
		int arr2[] = {8,5,2,6,9,3,1,4,0,7};
		insertsort(arr2);
		
		return;
		
	}
	
	
	/**
	 * 
	 * 간단 설명 : 오른쪽으로 가면서 가장작은것을 찾은 뒤 현재 index에 위치한 값과 swap
	 * 최소 값을 누적하며 끝까지 비교 후 최소 값의 index를 참조하여 "한 번" 스왑함.
	 * @param arr
	 */
	private static void selectsort(int arr[])
	{
		//init print
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
		System.out.print(" -- select sort --> ");
		
		
		for(int i=0;i<arr.length-1;i++)
		{
			int minimumV = i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[minimumV] >= arr[j])
				{
					minimumV = j;
				}
			}
			
			int tempvalue = arr[minimumV];
			arr[minimumV] = arr[i];
			arr[i] = tempvalue;
			
		}
		
		//print
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
		return;
	}
	
	/**
	 * 
	 * 간단 설명 : 왼쪽값 중에서, 현재 index 보다 큰 값을 찾아서 swap.
	 * 왼쪽으로 가므로 i가 2번째부터 시작함.
	 * pivot에는 왼쪽 값을 비교할 "고정 값" 들어감. swap은 index로 동작함. 
	 *  
	 * @param arr
	 */
	private static void insertsort(int arr[])
	{
		//init print
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
		System.out.print(" -- insert sort --> ");
		
		
		for(int i=1;i<arr.length;i++)
		{
			int pivot = arr[i];
			int index = i;
			for(int j=(i-1);j>=0;j--)
			{
				if(arr[j] >= pivot)
				{
					int temp = arr[index];
					arr[index] = arr[j];
					arr[j] = temp;
					
					index = j;
				}
			}
		}
		
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
		return;
		
	}
	
}
