package LeetCode.Contest.Weekly404;

public class MaximumHeightOfATriangle {

    public int maxHeightOfTriangle(int red, int blue) {
        int maxHeight = 0;
        int i = 1;
        int redCopy = red;
        int blueCopy = blue;
        while (redCopy > 0 && blueCopy > 0) {
            if ((i % 2 == 0 && blueCopy < i) || (i % 2 != 0 && redCopy < i)) {
                break;
            }
            if (i % 2 == 0)
                blueCopy -= i;
            else
                redCopy -= i;
            i++;
        }
        if (i - 1 > maxHeight) maxHeight = i;
        redCopy = red;
        blueCopy = blue;
        i = 1;
        while (redCopy > 0 && blueCopy > 0) {
            if ((i % 2 != 0 && blueCopy < i) || (i % 2 == 0 && redCopy < i)) {
                break;
            }
            if (i % 2 == 0)
                redCopy -= i;
            else
                blueCopy -= i;
            i++;
        }
        if (i - 1 > maxHeight) maxHeight = i;
        return maxHeight;
    }

    public static void main(String[] args) {

    }

}
