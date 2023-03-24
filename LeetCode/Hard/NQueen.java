package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void blockPos(int x, int y, int[][] posMatrix, int n, int inc)
    {
        for(int i=0; i<n; i++)
        {
            if(posMatrix[i][y]<=0)
                posMatrix[i][y]+=inc;
        }
        for(int i=0; i<n; i++)
        {
            if(posMatrix[x][i]<=0)
                posMatrix[x][i]+=inc;
        }
        int min = Math.min(x,y);
        int i = x-min;
        int j = y-min;
        while(i<n && j<n)
        {
            if(posMatrix[i][j]<=0)
                posMatrix[i][j]+=inc;
            i++;
            j++;
        }
        i = x-1;
        j = y+1;
        while(i>=0 && j<n)
        {
            if(posMatrix[i][j]<=0)
                posMatrix[i][j]+=inc;
            i--;
            j++;
        }
        i = x+1;
        j = y-1;
        while(i<n && j>=0)
        {
            if(posMatrix[i][j]<=0)
                posMatrix[i][j]+=inc;
            i++;
            j--;
        }
    }

    public static void backtrack(int row, List<List<String>> result, int[][] posMatrix, int n)
    {
        if(row>=n)
        {
            List<String> list = new ArrayList<>();

            for(int i=0; i<n; i++)
            {
                StringBuilder temp = new StringBuilder();
                for(int j=0; j<n; j++)
                {
                    if(posMatrix[i][j]>=1)
                        temp.append('Q');
                    else
                        temp.append('.');
                }
                list.add(temp.toString());
            }
            result.add(list);
        }
        else
        {
            for(int i=0; i<n; i++)
            {
                if(posMatrix[row][i]==0)
                {
                    posMatrix[row][i] = row+1;
                    blockPos(row,i,posMatrix,n,-1);
                    backtrack(row+1, result, posMatrix, n);
                    blockPos(row,i,posMatrix,n,1);
                    posMatrix[row][i] = 0;
                }
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        int[][] posMatrix = new int[n][n];
        backtrack(0,result,posMatrix,n);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

}
