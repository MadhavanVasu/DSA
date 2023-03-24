package LeetCode.Medium;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        int n = s.length();
        if(n==1 || numRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++)
        {
            int j = i;
            sb.append(s.charAt(i));
            while (true)
            {
                int steps = (numRows-i-1)*2;
                int pos = j + steps;
                if(pos>=n)
                    break;
                if(pos!=j)
                    sb.append(s.charAt(pos));
                int newPos = (((numRows-1)*2)-steps);
                if(newPos!=0)
                {
                    pos+=newPos;
                    if(pos>=n)
                        break;
                    sb.append(s.charAt(pos));
                }
                j = pos;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));

    }

}
