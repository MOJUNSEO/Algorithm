package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class no14891_wheel_SWtest {
    static int data[][];
    static int visit[][];
    static int cycle = 0;
    static int score = 0;
    static Scanner sc;
    static int checkerLR = 0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        data = new int[4][8];
        visit = new int[4][8];
        getData();

        for(int i=0;i<cycle;i++)
        {
            int number = sc.nextInt();
            int where = sc.nextInt();
            turn(number,where);
        }



    }

    public static void turn(int number, int where)
    {

        //맵 넣지말고, 다음 좌표만 넣어서 다시할 것 
        int col = number -1;
        int mask_col[] = {-1,1};
        Queue<int[][]> q = new LinkedList<>();
        q.add(data);

        visit[col][2] = 1;
        visit[col][6] = 1;

        while(!q.isEmpty())
        {
            int nowdata[][] = q.poll();
            //해당 바퀴를 돌려놓고 다음것을 돌릴지 말지 결정
            checkerLR = where;
            shiftLR(nowdata,number-1,checkerLR);
            changechecker(checkerLR);
            for(int i=0;i<2;i++)
            {
                int nextcol = col + mask_col[i];
                //배열 범위안에 있으면 동작
                if(nextcol > -1 && nextcol < 4)
                {
                    //왼쪽꺼 탐색
                    if(i==0 && (data[nextcol][2] != data[col][6]))
                    {

                    }
                    // 오른쪽 꺼 탐색
                    if(1==1 && (data[nextcol][6] != data[col[2]]))
                    {

                    }
                }
            }
        }



    }

    //방향제어
    public static void changechecker(int where)
    {
        if(where == -1)
        {
            checkerLR = 1;
        }
        else if(where == 1)
        {
            checkerLR = -1;
        }
    }

    //점수체크 (턴한번하고 체크)
    public static void countN()
    {
        for(int i=0;i<4;i++)
        {
            if(i==0 && data[i][0] == 1)
            {
                score += 1;
            }
            else if(i==1 && data[i][0] == 1)
            {
                score += 2;
            }
            else if(i==2 && data[i][0] == 1)
            {
                score += 4;
            }
            else if(i==3 && data[i][0] == 1)
            {
                score += 8;
            }
        }
    }

    //방향이동후
    public static void shiftLR(int arr[][],int col, int where) {
        //반시계
        if(where == -1)
        {
            int temp = arr[col][0];
            for(int i=0;i<arr.length-2;i++)
            {
                arr[col][i] = arr[col][i+1];
                if(i == arr.length-2)
                {
                    arr[col][i+1] = temp;
                }
            }
        }
        //시계
        else if(where == 1)
        {
            int temp = arr[col][arr.length-1];
            for(int i=(arr.length-1);i>=0;i--)
            {
                arr[col][i] = arr[col][i-1];
                if(i==0)
                {
                    arr[col][0] = temp;
                }
            }

        }
    }

    public static void getData()
    {
        sc = new Scanner(System.in);

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<8;j++)
            {
                visit[i][j] = 0;
            }
        }

        for(int i=0;i<4;i++)
        {
            String temp[] = sc.nextLine().split("");
            for(int j=0;j<temp.length;j++)
            {
                data[i][j] = Integer.parseInt(temp[j]);
            }
        }

        cycle = sc.nextInt();
    }
}
