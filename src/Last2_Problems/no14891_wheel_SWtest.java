package Last2_Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
* https://www.acmicpc.net/problem/14891
* 톱니바퀴로 인식하지말고, 배열의 몇번째 인덳드로 이동하는것인지에 중점!
* 큐에 넣는 값은 map이 아닌 다음 경로의 col값이다.
* */
public class no14891_wheel_SWtest {
    static int data[][];
    static int visit[][];
    static int cycle = 0;
    static int score = 0;
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        data = new int[4][8];
        visit = new int[4][8];

        initvisit();

        for(int i=0;i<4;i++)
        {
            String temp[] = sc.nextLine().split("");
            for(int j=0;j<temp.length;j++)
            {
                data[i][j] = Integer.parseInt(temp[j]);
            }
        }

        cycle = sc.nextInt();

        for(int i=0;i<cycle;i++)
        {
            turn();
            initvisit();
        }

        countN();



    }

    public static void turn()
    {
        int number = sc.nextInt();
        int where = sc.nextInt();

        int col = (number -1);
        int mask_col[] = {-1,1};

        Queue<colAndrow> q = new LinkedList<>();

        //시작정보셋팅
        q.add(new colAndrow(col,where));


        while(!q.isEmpty())
        {
            //꺼내서 정보 받음
            int nowcol = q.peek().col;
            int nowwhere = q.poll().where;

            //다음에 갈꺼 추가
            for(int i=0;i<2;i++)
            {
                int nextcol = nowcol + mask_col[i];
                //배열안에 있고 0,1,2,3
                if(nextcol >= 0 && nextcol <= 3)
                {
                    //왼쪽으로 가는데, 극이 다른 경우
                    if (i == 0 && (data[nextcol][2] != data[nowcol][6]))
                    {
                        //아직 방문안한 바퀴이면
                        if(visit[nextcol][2] == 0)
                        {
                            int tempLR = changechecker(nowwhere);
                            q.add(new colAndrow(nextcol, tempLR));
                            visit[nextcol][2] = 1;
                        }
                    }
                    //오른쪽으로 갈 경우
                    else if (i == 1 && (data[nextcol][6] != data[nowcol][2]))
                    {
                        if(visit[nextcol][6] == 0)
                        {
                            int tempLR = changechecker(nowwhere);
                            q.add(new colAndrow(nextcol, tempLR));
                            visit[nextcol][6] = 1;
                        }
                    }
                }
            }
            visit[nowcol][2] = 1;
            visit[nowcol][6] = 1;
            shiftLR(nowcol,nowwhere);
        }
    }


    private static void initvisit()
    {
        //visit 초기화
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<8;j++)
            {
                visit[i][j] = 0;
            }
        }
    }

    private static int changechecker(int where)
    {
        if(where == -1)
        {
            return 1;
        }
        else if(where == 1)
        {
            return -1;
        }
        return 0;
    }

    //점수체크 (턴한번하고 체크)
    private static void countN()
    {
        for(int i=0; i<4 ; i++)
        {
            if(data[i][0] == 1)
            {
                if(i == 0)
                {
                    score += 1;
                }
                if(i == 1)
                {
                    score += 2;
                }
                if(i == 2)
                {
                    score += 4;
                }
                if(i == 3)
                {
                    score += 8;
                }
            }
            else if(data[i][0] == 0)
            {
                score += 0;
            }
        }
        System.out.println(score);
    }

    //방향이동후
    private static void shiftLR(int col, int where) {
        //반시계
        if(where == -1)
        {
            int temp = data[col][0];
            for(int i=0;i<7;i++)
            {
                data[col][i] = data[col][i+1];
                if(i == 6)
                {
                    data[col][i+1] = temp;
                }
            }
        }
        //시계
        else if(where == 1)
        {
            int temp = data[col][7];
            for(int i=7;i>0;i--)
            {
                data[col][i] = data[col][i-1];
                if(i==1)
                {
                    data[col][0] = temp;
                }
            }

        }
    }
}

class colAndrow
{
    int col;
    int where;
    public colAndrow(int col, int where)
    {
        this.col = col;
        this.where = where;
    }
}
