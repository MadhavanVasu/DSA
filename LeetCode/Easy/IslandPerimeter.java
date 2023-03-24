package Easy;


public class IslandPerimeter{

	public static boolean isValid(int x, int y, int n, int m)
	{
		if(x>=0 && x<n && y>=0 && y<m)
		{
			return true;
		}
		return false;
	}

	public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
		int n = grid.length;
		int m = grid[0].length;
		for(int i = 0;i<n;i++)
		{
			for(int j = 0; j<m; j++)
			{
				if(grid[i][j]==1)
				{
					int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
					for(int k = 0; k<4; k++)
					{
						int x = i+pos[k][0];
						int y = j+pos[k][1];
						if(isValid(x, y, n, m))
						{
							if(grid[x][y]==0)
								perimeter+=1;
						}
						else
							perimeter+=1;
					}
					
				}
			}
		}
		return perimeter;
        
    }

    public static void main(String[] args) {

		int grid[][] = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(islandPerimeter(grid));
		
	}
}