package LeetCode.Easy;

public class GCDOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        int i = 0;
        int j = 0;
        int n1 = str1.length();
        int n2 = str2.length();
        while (i < n1 && j < n2) {
            if (str1.charAt(i) != str2.charAt(j))
                break;
            i++;
            j++;
        }
        if (i == 0)
            return "";
        if (i == n1 && j == n2)
            return str1;
        if (i == n1)
            return gcdOfStrings(str1, str2.substring(j, n2));
        else if (j == n2)
            return gcdOfStrings(str2, str1.substring(i, n1));
        return "";
    }


    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(str1, str2));
    }

}
