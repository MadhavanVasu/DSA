package LeetCode.Contest.Biweekly110;

public class AccountBalance {

    public int accountBalanceAfterPurchase(int purchaseAmount) {

        if (purchaseAmount == 0) return 100;
        int q = purchaseAmount / 10;
        int multiple1 = q * 10;
        int multiple2 = (q + 1) * 10;
        if (Math.abs(purchaseAmount - multiple2) == Math.abs(purchaseAmount - multiple1)) return 100 - multiple2;
        else if (Math.abs(purchaseAmount - multiple1) < Math.abs(purchaseAmount - multiple2)) return 100 - multiple1;
        return 100 - multiple2;
    }

    public static void main(String[] args) {

    }

}
