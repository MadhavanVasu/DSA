package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>(List.of(1));
            for (int j = 1; j <= result.size() - 1; j++) {
                int val = result.get(j - 1) + result.get(j);
                temp.add(val);
            }
            temp.add(1);
            result = new ArrayList<>(temp);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
