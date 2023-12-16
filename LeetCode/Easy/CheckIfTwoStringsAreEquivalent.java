//package LeetCode.Easy;
//
//public class CheckIfTwoStringsAreEquivalent {
//
//    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        int i = 0;
//        int j = 0;
//        int x = 0;
//        int y = 0;
//        while (i < word1.length && j < word2.length) {
//            if (x >= word1[i].length() || y >= word2[j].length) {
//                if (x >= word1[i].length()) {
//                    i++;
//                    x = 0;
//                }
//                if (y >= word2[j].length()) {
//                    j++;
//                    y = 0;
//                }
//            } else {
//                if (word1[i].charAt(x) != word2[j].charAt(y)) return false;
//                x++;
//                y++;
//            }
//        }
//        return i >= word1.length && j >= word2.length;
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
