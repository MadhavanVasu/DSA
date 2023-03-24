package Easy;

public class DigPrint {
    public static void main(String[] args) {
        int x = 58303;
	    int i = 10000;
	    while(i>0)
	    {
		    int rem = x/i;
		    System.out.println(rem);
		    x = x%i;
		    i = i/10;
	    }
        
    }
}
