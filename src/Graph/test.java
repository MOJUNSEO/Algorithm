package Graph;

import javax.swing.plaf.synth.SynthToggleButtonUI;

public class test {
	public static void main(String[] args) {
		System.out.println("start test");
		int[][] test = new int[3][3];
		int visit[] = {1,1,1 };
		for(int i=0;i<3;i++)
		{
			test[i] = visit;
		}
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("length : " + test.length);
	}
}
