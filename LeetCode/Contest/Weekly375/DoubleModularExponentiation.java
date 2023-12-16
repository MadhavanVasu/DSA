//package LeetCode.Contest.Weekly375;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DoubleModularExponentiation {
//
//    public List<Integer> getGoodIndices(int[][] variables, int target) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < variables.length; i++) {
//            int a = variables[i][0];
//            int b = variables[i][1];
//            int c = variables[i][2];
//            int m = variables[i][3];
//            int value = (int) ((Math.pow((Math.pow(a, b) % 10), c)) % m);
//            if (value == target) result.add(i);
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//
//        // 2 4 8 16 32 64 128
//        System.out.println(new DoubleModularExponentiation().getGoodIndices(new int[][]{{1, 3, 4, 5}}));
//
//
//
//    }
//
//}
