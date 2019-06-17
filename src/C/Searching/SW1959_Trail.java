package C.Searching;

import java.util.Scanner;

/*

참고 https://penglog.tistory.com/102
https://whereisusb.tistory.com/173
 */

public class SW1959_Trail {
    static int map[][] = null;
    static boolean visit[][] = null;
    static int MAXinMap = Integer.MIN_VALUE;
    static int wayCnt = 0;
    static int K = 0;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int N = 0;
        int height = 0;

        for(int i=0; i<testcase; i++)
        {
            N = sc.nextInt();
            if(N < 3 || N > 9)
            {
                return;
            }

            K= sc.nextInt();
            if(K < 1 || K > 5)
            {
                return;
            }

            map = new int[N][N];
            for(int y = 0; y < N; y++)
            {
                for(int x = 0; x < N; x++)
                {
                    map[y][x] = sc.nextInt();
                    if(map[y][x] < 1 || map[y][x] > 20)
                    {
                        return;
                    }
                    if(map[y][x] > MAXinMap)
                    {
                        MAXinMap = map[y][x];
                    }
                }
            }

            for(int y = 0; y < N; y++)
            {
                for(int x = 0; x < N; x++)
                {
                    if(map[y][x] == MAXinMap)
                    {
                        visit = new boolean[N][N];
                        DFS(y,x,false,1);
                    }
                }
            }

        }
    }


    static void DFS(int col, int row, boolean YN, int cnt)
    {
        int d_y[] = {1,-1,0,0};
        int d_x[] = {0,0,-1,1};

        visit[col][row] = true;

        for(int i=0;i<4;i++)
        {
            int ne_col = col + d_y[i];
            int ne_row = row + d_y[i];
            if(ne_col >= 0 && ne_col < map.length)
            {
                if(ne_row >= 0 && ne_row < map.length)
                {
                    if(visit[ne_col][ne_row] == false)
                    {
                        if(map[ne_col][ne_row] < map[col][row])
                        {
                            DFS(ne_col, ne_row, false , cnt++);
                        }
                        else
                        {
                            //다음 것이 지금거랑 같거나 클 경우
                            if(YN == false )
                            {
                                //공사해야함 1~K까지 하는경우는 다음 진로에 영향을 미치기떄문
                                for(int w = 1; w <=K; w++)
                                {
                                    //DFS()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
