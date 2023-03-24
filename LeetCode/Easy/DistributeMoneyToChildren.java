package LeetCode.Easy;

public class DistributeMoneyToChildren {

    public int distMoney(int money, int children) {
        if (children > money)
            return -1;
        int res = 0;
        while (children > 0) {
            int remMoney = money - 8;
            if (children - 1 > remMoney || (children - 1 == 1 && remMoney == 4))
                return res;
            else if (children != 1 || remMoney == 0)
                res++;
            money -= 8;
            children--;
        }
        return res;
    }

}
