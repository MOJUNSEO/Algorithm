package Z.Last2_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// SW maestro 지원 대비 모르는 것 위주 문제임
// 문자열 찾기 
public class SM_findString {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String text = in.readLine();
		
		while(true)
		{
			String searchtext = in.readLine();
			if(searchtext.equals("exit"))
			{
				out.write("종료");
				in.close();
				out.close();
				return;
			}
			else
			{
				boolean YN = text.contains(searchtext);
				if(YN == true)
				{
					out.write(searchtext + " 가 있습니다.");
					out.flush();
				}
				else
				{
					out.write(searchtext + " 가 없습니다.");
					out.flush();
				}
				
			}
		}
	}
}
