package LeetCode.Contest.Weekly388;

public class ShortestUncommonSubstringInAnArray {

    public boolean isSubstring(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        for (int i = 0; i < n1 - n2; i++) {
            boolean flag = true;
            for (int j = 0; j < n2; j++) {
                if (str2.charAt(j) != str1.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }

    public String findUncommonSubstr(int i, String[] arr) {
        String result = "";
        for (int j = 0; j < arr[i].length(); j++) {
            for (int k = 0; k < arr[i].length() - j; k++) {
                String subtr = arr[i].substring(k, k + j + 1);
                boolean flag = true;
                for (int x = 0; x < arr.length; x++) {
                    if (x != i) {
                        if (isSubstring(subtr, arr[x])) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    if (result.equals("") || (result.compareTo(subtr) > 0 && result.length() == subtr.length()))
                        result = subtr;
                    else if (!result.equals("") && result.length() < subtr.length()) return result;
                }
            }
        }
        return "";
    }

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String min = findUncommonSubstr(i, arr);
            result[i] = min;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
