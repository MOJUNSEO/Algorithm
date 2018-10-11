package Last2_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// SW maestro 지원 대비 모르는 것 위주 문제임
// 진법 변환 
public class SM_numberTonumber {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> checklist = new ArrayList<>();
		checklist.add("2");checklist.add("8");checklist.add("16");
		
		String temp[] = in.readLine().split(" ");
		
		
		if(checklist.contains(temp[1]))
		{
			
			if(temp[1].equals("2"))
			{
				String output = Integer.toBinaryString(Integer.parseInt(temp[0]));
				out.write(temp[0] + "을 " + temp[1] + "으로 바꾸면  " +output);
				out.write(output);
			}
			else if(temp[1].equals("8"))
			{
				String output = Integer.toBinaryString(Integer.parseInt(temp[0]));
				out.write(output);
			}
			else if(temp[1].equals("16"))
			{
				String output = Integer.toBinaryString(Integer.parseInt(temp[0]));
				out.write(output);
			}				
		}
		else
		{
			System.out.println("변환 진수를 확인하세요.");
			return;
		}
		
		in.close();
		out.close();
		
	}
	
	
}
