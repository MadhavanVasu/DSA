package LeetCode.Medium;

// https://leetcode.com/problems/fruit-into-baskets/

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        int count = 0;
        int max = 0;
        int[] basket = {-1,-1};
        int n = fruits.length;
        for(int i=0; i<n; i++)
        {
            if(basket[0]==-1)
            {
                count+=1;
                basket[0] = i;
            }
            else if(basket[1]==-1 && fruits[basket[0]]!=fruits[i])
            {
                count+=1;
                basket[1] = i;
            }
            else {
                if(fruits[i]==fruits[basket[0]])
                {
                    count+=1;
                    basket[0] = i;
                }
                else if(fruits[i]==fruits[basket[1]])
                {
                    count+=1;
                    basket[1] = i;
                }
                else {
                    if(basket[0]==i-1)
                    {
                        count = basket[0]-basket[1] + 1;
                        basket[1] = i;
                    }
                    else {
                        count = basket[1] - basket[0] + 1;
                        basket[0] = basket[1];
                        basket[1] = i;
                    }
                }
            }
            if(count>max)
                max = count;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] fruits = {0};
        System.out.println(totalFruit(fruits));
    }

}
