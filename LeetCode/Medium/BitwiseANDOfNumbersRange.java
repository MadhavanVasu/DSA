package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        if (left == right || left == 0) return left;
        List<Integer> leftBits = new ArrayList<>();
        List<Integer> rightBits = new ArrayList<>();
        while (left > 0) {
            leftBits.add(left % 2);
            left /= 2;
        }
        while (right > 0) {
            rightBits.add(right % 2);
            right /= 2;
        }
        Collections.reverse(leftBits);
        Collections.reverse(rightBits);
        if (leftBits.size() != rightBits.size()) return 0;
        int i = 0;
        int j = leftBits.size() - 1;
        int result = 0;
        while (i < leftBits.size()) {
            if (leftBits.get(i) == 0 || rightBits.get(i) == 0) break;
            result += (Math.pow(2, j));
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
