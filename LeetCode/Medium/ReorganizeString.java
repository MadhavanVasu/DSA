package LeetCode.Medium;

import java.util.*;

public class ReorganizeString {

    class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character x : s.toCharArray())
            charCount.put(x, charCount.getOrDefault(x, 0) + 1);
        Comparator<Pair> customComparator = (a, b) -> Integer.compare(b.count, a.count);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(customComparator);
        for (Character c : charCount.keySet()) {
            maxHeap.add(new Pair(c, charCount.get(c)));
        }
        int n = s.length();
        Character[] charArr = new Character[n];
        if (maxHeap.peek().count > (n + 1) / 2) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Pair character = maxHeap.poll();
            while (character.count > 0) {

                if ((charArr[i]==null) && (i - 1 < 0 || charArr[i - 1] == null || charArr[i - 1] != character.c) && (i + 1 >= n || charArr[i + 1] == null || charArr[i + 1] != character.c)) {
                    charArr[i] = character.c;
                    character.count--;
                    i = (i + 2) % n;
                }
                else if(charArr[i]!=null && (charArr[i]!=character.c) && (i - 1 < 0 || charArr[i - 1] == null || charArr[i - 1] != character.c))
                {

                }


            }
            i = (i + 1) % n;
        }
        for (Character c : charArr)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new ReorganizeString().reorganizeString("abbabbaaab"));

//        0 1 2 3 4 5 6 7 8 9
//        a   a   a   a   a

    }


}
