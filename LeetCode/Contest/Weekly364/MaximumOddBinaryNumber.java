package LeetCode.Contest.Weekly364;

public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Character x : s.toCharArray())
        {
            if(x=='1') count++;
        }
        for (int i=0; i<count-1; i++)
            sb.append('1');
        for(int i=0; i<s.length()-count; i++)
            sb.append('0');
        sb.append('1');
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
