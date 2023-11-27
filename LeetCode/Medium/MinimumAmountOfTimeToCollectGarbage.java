package LeetCode.Medium;

public class MinimumAmountOfTimeToCollectGarbage {

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int prefixSum = 0;
        int garbageCollectionTime = 0;
        int lastPaperGarbage = 0;
        int lastGlassGarbage = 0;
        int lastMetalGarbage = 0;
        for (int i = 0; i < n; i++) {
            for (char x : garbage[i].toCharArray()) {
                if (x == 'G') lastGlassGarbage = prefixSum;
                else if (x == 'P') lastPaperGarbage = prefixSum;
                else lastMetalGarbage = prefixSum;
                garbageCollectionTime++;
            }
            if (i != n - 1) prefixSum += travel[i];
        }
        return garbageCollectionTime + lastGlassGarbage + lastMetalGarbage + lastPaperGarbage;
    }

    public static void main(String[] args) {

    }

}
