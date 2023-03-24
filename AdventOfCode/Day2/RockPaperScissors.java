package AdventOfCode.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {

    public static int findScorePart2(String filename) {
        BufferedReader reader;
        int score = 0;
        Map<String, Integer> drawMap = new HashMap<>() {{
            put("A", 1);
            put("B", 2);
            put("C", 3);
        }};

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split(" ");
                if (arr[1].equals("Y")) score += (drawMap.get(arr[0]) + 3);
                else if (arr[1].equals("Z")) score += ((drawMap.get(arr[0]) + 1) > 3 ? 7 : drawMap.get(arr[0]) + 7);
                else score += ((drawMap.get(arr[0]) - 1) == 0 ? 3 : drawMap.get(arr[0]) - 1);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return score;
    }

    public static int findScorePart1(String filename) {
        BufferedReader reader;
        int score = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("A", 1);
        scoreMap.put("X", 1);
        scoreMap.put("B", 2);
        scoreMap.put("Y", 2);
        scoreMap.put("C", 3);
        scoreMap.put("Z", 3);
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split(" ");
                score += scoreMap.get(arr[1]);
                if (scoreMap.get(arr[0]) < scoreMap.get(arr[1]) && !(arr[0].equals("A") && arr[1].equals("Z"))
                        || (scoreMap.get(arr[0]) > scoreMap.get(arr[1]) && (arr[0].equals("C") && arr[1].equals("X"))))
                    score += 6;
                else if (scoreMap.get(arr[0]).equals(scoreMap.get(arr[1]))) score += 3;
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename : ");
        String filename = sc.nextLine();

        System.out.println(findScorePart1(filename));
        System.out.println(findScorePart2(filename));
    }

}
