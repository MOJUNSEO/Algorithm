package Last_Problems;import java.util.Random;

public class RecordMaker {
	public static void main(String[] args) {
		Random random = new Random();
		String argv = args[0];
		int count = Integer.parseInt(argv);
		
		String arr[] = new String[count];
		
		for(int i=0;i<count;i++)
		{
			int temp = random.nextInt(10000);
			String str = Integer.toString(temp);
			if(str.length() != 5)
			{
				int addzero = (5-str.length());
				for(int j=0;j<addzero;j++)
				{
					str = "0" + str;
				}
			}
			str = "NT" + str;
			arr[i] = str;
		}		
		for(int k=0;k<arr.length;k++)
		{
			int score = random.nextInt(100);
			System.out.println(arr[k] + " " +score);
		}
	}
}
