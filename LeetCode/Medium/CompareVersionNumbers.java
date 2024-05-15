package LeetCode.Medium;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n1 = arr1.length;
        int n2 = arr2.length;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < n1) num1 = Integer.parseInt(arr1[i]);
            if (i < n2) num2 = Integer.parseInt(arr2[i]);
            if (num1 > num2) return 1;
            else if (num2 > num1) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("0.1", "1.1"));
    }

}
