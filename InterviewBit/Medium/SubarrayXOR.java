package InterviewBit.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayXOR {

    public static int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int result = 0;
        for (int x : A) {
            xor ^= x;
            if (map.containsKey(xor ^ B)) result += map.get(xor ^ B);
            if (xor == B) result += 1;
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(List.of(4, 2, 2, 6, 4));
        ArrayList<Integer> A = new ArrayList<>(List.of(6, 6, 6));
        int B = 6;
        System.out.println(solve(A, B));
    }

}
