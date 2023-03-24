package Gfg.Medium;

import Gfg.Model.Job;

import java.util.*;

public class JobSequencingProb {

    public static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return Integer.compare(o2.profit, o1.profit);
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    static int[] JobScheduling(Job arr[], int n) {
        int[] result = {0, 0};
        Comparator<Job> comparator = new JobComparator();
        Arrays.sort(arr, comparator);
        Integer[] day = new Integer[n];
        for (Job x : arr) {
            if (x.deadline > n) {
                result[0]++;
                result[1] += x.profit;
            } else {
                int j = x.deadline - 1;
                while (j >= 0) {
                    if (day[j] == null) {
                        day[j] = x.profit;
                        result[0]++;
                        result[1] += x.profit;
                        break;
                    }
                    j--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int n = 4;
//        String s = "1 56 288 2 27 435 3 67 401 4 64 368 5 94 248 6 54 361 7 43 108 8 96 167 9 73 251 10 96 170 11 14 156 12 78 184 13 61 370 14 77 424 15 68 397 16 40 375 17 36 218";
        String s = "1 4 20 2 1 10 3 1 40 4 1 30";

        String[] arrOfStr = s.split(" ");
        Job[] arr = new Job[n];
        int j = 0;
        for (int i = 0; i < arrOfStr.length; i += 3) {
            int jobId = Integer.parseInt(arrOfStr[i]);
            int deadline = Integer.parseInt(arrOfStr[i + 1]);
            int profit = Integer.parseInt(arrOfStr[i + 2]);
            Job job = new Job(jobId, deadline, profit);
            arr[j] = job;
            j++;
        }
        int[] result = JobScheduling(arr, n);
        System.out.println(Arrays.toString(result));

    }

}
