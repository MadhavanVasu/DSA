package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static boolean dfs(int v, int[] visited, int[] mainVisited, List<List<Integer>> adjList)
    {
        visited[v] = 1;
        for(int x : adjList.get(v))
        {
            if(mainVisited[x]==1)
                continue;
            if(visited[x]==1)
                return false;
            boolean f = dfs(x, visited, mainVisited, adjList);
            if(!f)
                return false;
        }
        visited[v] = 0;
        mainVisited[v] = 1;

        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            adjList.add(new ArrayList<>());
        for(int[] x : prerequisites)
            adjList.get(x[0]).add(x[1]);
        int[] mainVisited = new int[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(mainVisited[i]==0 && !adjList.get(i).isEmpty())
            {
                int[] visited = new int[numCourses];
                boolean val = dfs(i,visited, mainVisited,adjList);
                if(!val)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {{0,1},{0,2},{1,2},{2,0}};
        System.out.println(canFinish(numCourses, prerequisites));

    }

}
