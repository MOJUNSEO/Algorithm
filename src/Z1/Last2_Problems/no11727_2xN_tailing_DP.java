package Z1.Last2_Problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11727
 * DP문제는 실제로 1-3의 test를 하면서 점화식을 구한뒤 n=0일 경우 1로 해야하는지 아닌지를 점화식에 근거하여 설정해야한다. 
 * */
public class no11727_2xN_tailing_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int D[] = new int[N+1];
		//입력한 N까지 구해야하므로 
		
		D[0] = 1;
		D[1] = 1;
				
		for(int i = 2 ; i < D.length ; i++)
		{
			D[i] = D[i-1] + D[i-2]*2;
			D[i] = D[i]%10007;
		}
		System.out.println(D[N]);
	}
}
