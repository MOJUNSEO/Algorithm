package Z1.Last2_Problems;

import java.util.Scanner;
import java.util.Stack;

/*
* https://www.acmicpc.net/problem/14889
*
* 명(수)가 주어지고, 반반으로 팀을 하게된다.
* 표는 각팀의 시너지임.
* 반반씩 가를 때, 누구누구누구가 팀을 먹어야 능력치가 최소가 되겠는지.
*
* */
public class no14889_StartLinkteam_SWtest {
    static int map[][];
    static boolean visit[];
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N];

        //get data
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
            }
        }

        Dfs(0,0);
        System.out.println(min);

    }

    private static void Dfs(int v, int len)
    {
        if(len == N/2)
        {
            divide();
        }
        else
        {
            for(int i = v; i<N ; i++)
            {
                if(visit[i] != true)
                {
                    visit[i] = true;
                    Dfs(i,len+1);
                }
            }
        }
        visit[v] = false;

    }

    private static void divide()
    {
        int a[] = new int[N/2];
        int b[] = new int[N/2];

        int apoint = 0;
        int bpoint = 0;
        for(int i=0;i<N;i++)
        {
            if(visit[i] == true)
            {
                a[apoint] = i+1;
                apoint++;
            }
            else
            {
                b[bpoint] = i+1;
                bpoint++;
            }
        }

        //예를 들어~ 부분이 DP수식의 힌트가 되는 듯?-!!!!
        int aAbility = getStat(a);
        int bAbility = getStat(b);
        int differValue = Math.abs(aAbility - bAbility);
        if(min > differValue)
        {
            min = differValue;
        }
        //예를 들어~ 부분이 DP수식의 힌트가 되는 듯?-!!
    }


    public static int getStat(int[] array) {
        int result = 0;
        int len = N / 2;

        for(int i=0;i<(N/2)-1;i++)
        {
            for(int j=i+1;j<(N/2)-1;j++)
            {
                result += map[array[i]][array[j]];
                result += map[array[j]][array[i]];
            }
        }

        return result;
    }


}
