//package Gfg.Hard;
//
//public class CandyDistributionProblem {
//
//    public int minCandy(int N, int ratings[]) {
//        int next = 2;
//        int result = 1;
//        int prevPeak = Integer.MAX_VALUE;
//        int start = 0;
//        int peakOrTroughOrFlat = 0;
//        int i = 0;
//        for (i = 1; i < N; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                if (start == i - 1) {
//                    peakOrTroughOrFlat = 1;
//                    result += next;
//                    next++;
//                }
//                else if(peakOrTroughOrFlat != 1) {
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new CandyDistributionProblem().minCandy(7, new int[]{3, 2, 1, 2, 3, 4, 5}));
//
//        // 3 2 1 5 4 3 2 1
//
//    }
//
//
//}
