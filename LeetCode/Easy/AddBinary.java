package LeetCode.Easy;

public class AddBinary {

    // Clean code
    public static String addBinaryClean(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        String res = "";
        int n1 = a.length();
        int n2 = b.length();
        if(n2>n1)
        {
            String temp = a;
            a = b;
            b = temp;
            n1 = a.length();
            n2 = b.length();
        }
        StringBuilder sb = new StringBuilder();
        int j = n1-1;
        for(int i=n2-1; i>=0; i--)
        {
            int x = Integer.parseInt(String.valueOf(a.charAt(j)));
            int y = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = 0;
            if(x==1 && y==1)
            {
                if(carry==1)
                    sum = 1;
                carry = 1;
            }
            else if(x==0 && y==0)
            {
                if(carry==1)
                    sum = 1;
                carry = 0;
            }
            sb.append(sum);
            j--;
        }
        while(j>=0)
        {
            if(carry==1)
            {
                if(a.charAt(j)=='1')
                    sb.append(0);
                else
                {
                    sb.append(1);
                    carry=0;
                }
            }
            else
            {
                carry = 0;
                sb.append(a.charAt(j));
            }
            j--;
        }
        if(carry==1)
            sb.append(1);
        res = sb.reverse().toString();
        return res;
    }

    public static void main(String[] args) {

        String a = "11";
        String b = "101101";
        System.out.println(addBinary(a,b));

    }

}
