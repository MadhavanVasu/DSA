package Gfg.Medium;

import Gfg.Easy.NMeetingInRoom;

import java.util.*;

public class MinimumPlatforms {

    public static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 0;
        int i = 0;
        int j = 0;
        int platforms = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                platforms++;
            } else {
                j++;
                platforms--;
            }
            if (platforms > max)
                max = platforms;
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arr, dep, n));
    }
}
