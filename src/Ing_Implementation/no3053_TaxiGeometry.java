package Ing_Implementation;

/* 유클리드 : 원 -> 동그라미
 * 택시 기하학 : 원 -> 정사각형
 *  */
import java.util.*;

public class no3053_TaxiGeometry {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int input_radius = sc.nextInt();
		
		__Solution(input_radius);
		sc.close();
		return;
	}
	
	private static void __Solution(int R)
	{
		__Uclrid(R);
		__Taxi(R);
		return;
	}
	
	private static void __Uclrid(int R)
	{
		double value = ((double)R*(double)R)*Math.PI;
		String result = String.format("%.6f\n", value);
		System.out.printf(result);
		return;
	}
	
	private static void __Taxi(int R)
	{
		double value = 2*Math.pow((double)R, 2);
		String result = String.format("%.6f\n", value);
		System.out.println(result);
		return;
	}
}
