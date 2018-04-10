package Problems;

import java.util.Scanner;

/*
* https://www.acmicpc.net/problem/14889
*
* 명(수)가 주어지고, 반반으로 팀을 하게된다.
* 표는 각팀의 시너지임.
* 반반씩 가를 때, 누구누구누구가 팀을 먹어야 능력치가 최소가 되겠는지.
* DP 문제인거같은데?
* */
public class no14889_StartLinkteam_SWtest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int members = sc.nextInt();
        int ablilty[][] = new int[members][members];
        int D[][] = new int[members][members];

        //get data
        for(int i=0;i<members;i++)
        {
            for(int j=0;j<members;j++)
            {
                ablilty[i][j] = sc.nextInt();
            }
        }

        //예를 들어~ 부분이 DP수식의 힌트가 되는 듯?-
    }
}
