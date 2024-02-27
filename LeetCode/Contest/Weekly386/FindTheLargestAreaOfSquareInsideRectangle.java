package LeetCode.Contest.Weekly386;

public class FindTheLargestAreaOfSquareInsideRectangle {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long result = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x1 = bottomLeft[i][0];
                long x2 = topRight[i][0];
                long y1 = bottomLeft[i][1];
                long y2 = topRight[i][1];
                long x3 = bottomLeft[j][0];
                long x4 = topRight[j][0];
                long y3 = bottomLeft[j][1];
                long y4 = topRight[j][1];
                long commonLength = 0;
                long commonBreadth;
                if (x3 <= x1 && x1 <= x4) {
                    if (x2 > x4) {
                        commonLength = x4 - x1;
                    } else commonLength = x2 - x1;
                } else continue;
                if (y3 <= y1 && y1 <= y4) {
                    if (y2 > y4) commonBreadth = y4 - y1;
                    else commonBreadth = y2 - y1;
                } else if (y1 <= y3 && y3 <= y2) {
                    if (y4 > y2) commonBreadth = y2 - y3;
                    else commonBreadth = y4 - y3;
                } else continue;
                long min = Math.min(commonBreadth, commonLength);
                result = Math.max(result, min);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] bottomLeft = new int[][]{{1, 1}, {2, 2}, {3, 1}};
        int[][] topRight = new int[][]{{3, 3}, {4, 4}, {6, 6}};
        System.out.println(new FindTheLargestAreaOfSquareInsideRectangle().largestSquareArea(bottomLeft, topRight));
    }

}
