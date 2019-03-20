package E.String;
import java.util.Scanner;
/*??????????????????????????????????????????????????????????*/
public class no1475_roomNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		//sc.nextLine();
		Solution(N);
		sc.close();
	}
	
	static void Solution(String N)
	{
		int arr[] = {1,1,1,1,1,1,1,1,1,1};
		int setNum = 1;
		int arrdex = 0;		
		
		while(arrdex < N.length())
		{
			// N에서 한글자를 떼다가 가져옴 
			int Nsvalue = Integer.parseInt(N.substring(arrdex, arrdex+1));
			//가져온 글자를 arr에서 가지고있는지 비교 
			
			//일단 이게 6,9 이냐 (뒤집어사용가능한지)
			if(Nsvalue == 6 && arr[6] == 0)
			{
				if(arr[9] > 0)
				{
					arr[9]--;
					arrdex++;
				}
			}
			if(Nsvalue == 9 && arr[9] == 0)
			{
				if(arr[6] > 0)
				{
					arr[6]--;
					arrdex++;
				}
			}
			if(arr[Nsvalue] > 0)
			{
				arr[Nsvalue]--;
				arrdex++;
			}
			else if(arr[Nsvalue] == 0)
			{
				setNum++;
				for(int i=0;i<arr.length;i++)
				{
					arr[i]++;
				}
			}
			System.out.println(setNum);
		}
		//System.out.println(setNum);
	}
}
