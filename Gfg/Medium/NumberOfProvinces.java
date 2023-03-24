package Gfg.Medium;

import java.util.*;

public class NumberOfProvinces {

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjList.add(new ArrayList<>());
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                if(adj.get(i).get(j)==1 && i!=j)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[V];
        int provinceCount = 0;
        for(int i=0; i<V; i++)
        {
            if(visited[i]!=1)
            {
                visited[i] = 1;
                queue.add(i);
                while (!queue.isEmpty())
                {
                    int v = queue.poll();
                    for(int j : adjList.get(v))
                    {
                        if(visited[j]!=1)
                        {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
                provinceCount++;
            }
        }
        return provinceCount;
    }

    public static void main(String[] args) {

        // {{1, 1},{1, 1}}
        // {{1, 0, 1},{0, 1, 0},{1, 0, 1}}
        int[][] input = {{1, 1},{1, 1}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int[] x : input)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int y : x)
                temp.add(y);
            adj.add(temp);
        }
        System.out.println(numProvinces(adj,2));

    }

}
