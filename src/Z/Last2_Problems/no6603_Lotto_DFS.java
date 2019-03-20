package Z.Last2_Problems;

import java.util.Scanner;

public class no6603_Lotto_DFS {
    static int T = 0;
    static int a[];
    static int result[];
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            String temp[] = sc.nextLine().split(" ");
            N = Integer.parseInt(temp[0]);
            if(N != 0)
            {
                a = new int[N];
                result = new int[N];
                for(int i=1;i<temp.length;i++)
                {
                    a[i-1] = Integer.parseInt(temp[i]);
                }
                Dfs(0, 0);
            }
            else
            {
                break;
            }
            System.out.println();
        }
    }

    private static void Dfs(int index,int depth)
    {
        if(depth == 6)
        {
            printarr();
        }
        else
        {
            for(int i=index; i < N; i++)
            {
                result[i] = 1;
                Dfs(i+1,depth+1);
                //0으로 돌려놓는 것이 백트래킹의 포인트
                result[i] = 0;
            }
        }
    }

    private static void printarr()
    {
        for(int i=0; i<N;i++)
        {
            if(result[i] == 1)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
    }
}
