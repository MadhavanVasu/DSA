package AdventOfCode.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RucksackReorg {

    public static int sumOfPrioritiesPart2(String filename) {
        BufferedReader reader;
        Map<Character, Integer> charMap;
        int sum = 0;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                int i = 1;
                charMap = new HashMap<>();
                while (i <= 3) {
                    int n = line.length();
                    for (int j = 0; j < n; j++) {
                        if (!charMap.containsKey(line.charAt(j)) && i == 1) {
                            charMap.put(line.charAt(j), i);
                        } else if (charMap.containsKey(line.charAt(j)) && i == 2) {
                            charMap.put(line.charAt(j), i);
                        } else if (charMap.containsKey(line.charAt(j)) && charMap.get(line.charAt(j)) == 2 && i == 3) {
                            int ascii = line.charAt(j);
                            if (ascii >= 97) sum += (ascii - 96);
                            else sum += (ascii - 64 + 26);
                            break;
                        }
                    }
                    i += 1;
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return sum;
    }

    public static int sumOfPrioritiesPart1(String filename) {
        BufferedReader reader;
        Set<Character> charSet;
        int sum = 0;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                int n = line.length();
                charSet = new HashSet<>();
                for (int i = 0; i < n / 2; i++) {
                    charSet.add(line.charAt(i));
                }

                for (int i = n / 2; i < n; i++) {
                    if (charSet.contains(line.charAt(i))) {
                        int ascii = line.charAt(i);
                        if (ascii >= 97) sum += (ascii - 96);
                        else sum += (ascii - 64 + 26);
                        break;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename : ");
        String filename = sc.nextLine();

        System.out.println(sumOfPrioritiesPart1(filename));
        System.out.println(sumOfPrioritiesPart2(filename));

    }

}
