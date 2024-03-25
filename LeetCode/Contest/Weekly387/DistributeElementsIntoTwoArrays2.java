package LeetCode.Contest.Weekly387;

import java.util.*;

public class DistributeElementsIntoTwoArrays2 {

    public int findGreaterCount(TreeSet<Integer> treeSet, int val) {
        SortedSet<Integer> greaterSet = treeSet.tailSet(val);
        return greaterSet.size();
    }

    public int[] resultArrayOptimized(int[] nums) {
        TreeSet<Integer> arr1Set = new TreeSet<>();
        TreeSet<Integer> arr2Set = new TreeSet<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int[] result = new int[nums.length];
        arr1.add(nums[0]);
        arr1Set.add(nums[0]);
        arr2.add(nums[1]);
        arr2Set.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int greaterCount1 = findGreaterCount(arr1Set, nums[i] + 1);
            int greaterCount2 = findGreaterCount(arr2Set, nums[i] + 1);
            if (greaterCount1 > greaterCount2) {
                arr1.add(nums[i]);
                arr1Set.add(nums[i]);
            } else if (greaterCount1 < greaterCount2 || arr1.size() > arr2.size()) {
                arr2.add(nums[i]);
                arr2Set.add(nums[i]);
            } else {
                arr1.add(nums[i]);
                arr1Set.add(nums[i]);
            }
        }
        int i = 0;
        while (i < arr1.size()) {
            result[i] = arr1.get(i);
            i++;
        }
        i = 0;
        while (i < arr2.size()) {
            result[i + arr1.size()] = arr2.get(i);
            i++;
        }
        return result;
    }

    public int[] greaterCount(PriorityQueue<int[]> pq, int val, int size1, int size2) {
        PriorityQueue<int[]> pqDup = new PriorityQueue<>(pq);
        while (!pqDup.isEmpty()) {
            if (pqDup.peek()[0] > val) break;
            int arr = pqDup.poll()[1];
            if (arr == 0) size1--;
            else size2--;
        }
        return new int[]{size1, size2};
    }

    public int[] resultArray(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        pq.add(new int[]{nums[0], 0});
        pq.add(new int[]{nums[1], 1});
        for (int i = 2; i < n; i++) {
            int[] size = greaterCount(pq, nums[i], arr1.size(), arr2.size());
            if (size[0] > size[1]) {
                pq.add(new int[]{nums[i], 0});
                arr1.add(nums[i]);
            } else if (size[0] < size[1]) {
                pq.add(new int[]{nums[i], 1});
                arr2.add(nums[i]);
            } else if (arr1.size() < arr2.size()) {
                pq.add(new int[]{nums[i], 0});
                arr1.add(nums[i]);
            } else if (arr1.size() > arr2.size()) {
                pq.add(new int[]{nums[i], 1});
                arr2.add(nums[i]);
            } else {
                pq.add(new int[]{nums[i], 0});
                arr1.add(nums[i]);
            }
        }
        int i = 0;
        while (i < arr1.size()) {
            result[i] = arr1.get(i);
            i++;
        }
        i = 0;
        while (i < arr2.size()) {
            result[i + arr1.size()] = arr2.get(i);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        Optional<Object> opt = Optional.ofNullable(null);
        System.out.println(opt.get());

    }

}
