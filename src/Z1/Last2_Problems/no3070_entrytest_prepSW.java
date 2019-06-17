package Z1.Last2_Problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/3079
 * 정답률 28%
 * 최소값을 구하는 것이기 때문에 BFS와 관련 있지 않을까 ? 혹은 DP
 * 큐를 이용하면 될듯 두개의 큐에 사람을 계속 쳐 집어넣자 집어넣으면서 초를 센다 
 * offer / poll 하면서 마지막까지 남은 초를 센다. 
 * no no no 
 * 이분탐색문제이다. 새로운경험;;;
 * 임의의 값을 투척하면서 범위를 좁혀 궁극적인 답을 찾아낸다. 
 * 
 * https://blog.naver.com/gyl115/221110159651
 * 여기 소스랑 다른게 뭔지,,,
 * */
public class no3070_entrytest_prepSW {
	public static void main(String[] args) throws Exception{
		Scanner sc =  new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testbox = 0;
		int people = 0;
		
		String temp[] = in.readLine().split(" ");
		
		testbox = Integer.parseInt(temp[0]);
		people = Integer.parseInt(temp[1]);
		
		int T[] = new int[testbox];
		int maxinT = 0;
		for(int i=0 ; i < testbox; i++)
		{
			T[i] = Integer.parseInt(in.readLine());
			if(T[i] > maxinT)
			{
				maxinT = T[i];
			}
		}
		
		long left = 0;
		//worst fit 
		long right = maxinT * people;
		
		//start binary search 
		while(left <= right)
		{
			long mid = (long)(left+right)/2;
			long nowpeople = 0;
			//찾고하자하는 값을 계산 
			for(int i=0; i<testbox;i++)
			{
				nowpeople += mid/T[i];
			}
			if(people <= nowpeople)
			{
				right = mid-1;
			}
			else
			{
				left = mid+1;
			}
		}
		System.out.println(left);
		in.close();
	}
}



/*
 *  차이점 분석할 것 
 * public class no3070_entrytest_prepSW {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] T = new int[N]; 
		int max = 0;
		for(int i=0;i<N;i++){
			T[i] = sc.nextInt();
			if(max < T[i])
				max = T[i];
		}
		long lo = 0;
		long hi = (long)max * M;
		while(lo < hi){
			long mid = (lo+hi)/2;
			long total = 0;
			for(int i=0;i<N;i++){
				total += mid/T[i];
			}
			if(total >= M){
				hi = mid;
			} else {
				lo = mid +1;
			}
		}
		
		System.out.println(lo);

	}
}

 * 
 * */
