package Gfg.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {

    public static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if (((double)o1.value)/o1.weight < ((double)o2.value)/o2.weight)
                return 1;
            else if (((double)o1.value)/o1.weight > ((double)o2.value)/o2.weight)
                return -1;
            return 0;
        }
    }

    //Function to get the maximum total value in the knapsack.
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        Comparator<Item> comparator = new ItemComparator();
        Arrays.sort(arr, comparator);
        double maxProfit = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i].weight>W)
            {
                maxProfit+=(((double)arr[i].value/arr[i].weight)*W);
                break;
            }
            maxProfit+=arr[i].value;
            W-=arr[i].weight;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int n = 3;
        Item[] arr = new Item[n];
        int W = 50;

        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        arr[2] = new Item(120, 30);

        System.out.println(fractionalKnapsack(W, arr, n));

    }

}
