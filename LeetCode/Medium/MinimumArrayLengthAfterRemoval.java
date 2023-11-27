//package LeetCode.Medium;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class MinimumArrayLengthAfterRemoval {
//
//    public int minLengthAfterRemovals(List<Integer> nums) {
//
//        int low = 0;
//        int high = 0;
//
//        Set<Integer> set = new HashSet<>();
//
//        while (high < nums.size()) {
//            if (nums.get(low) == nums.get(high)) {
//                high++;
//            } else {
//                if (!set.contains(low)) {
//                    set.add(high);
//                    set.add(low);
//                    high++;
//                }
//                low++;
//            }
//        }
//        return nums.size() - set.size();
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
