package AdventOfCode.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CalorieCounting {

    public static int getMaxCaloriePart1(String filename) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            Integer maxCalories = null;
            int calories = 0;
            while (line != null) {
                if (line.length() != 0) {
                    calories += Integer.parseInt(line);
                } else {
                    if (maxCalories == null || calories >= maxCalories) {
                        maxCalories = calories;
                    }
                    calories = 0;
                }
                line = reader.readLine();
            }
            reader.close();
            return maxCalories;
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return 0;
    }

    public static int getMaxCaloriePart2(String filename) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            Integer maxCalories1 = null;
            Integer maxCalories2 = null;
            Integer maxCalories3 = null;
            int calories = 0;
            while (line != null) {
                if (line.length() != 0) {
                    calories += Integer.parseInt(line);
                } else {
                    if (maxCalories1 == null || calories >= maxCalories1) {
                        Integer temp = maxCalories1;
                        maxCalories1 = calories;
                        maxCalories3 = maxCalories2;
                        maxCalories2 = temp;
                    } else if (maxCalories2 == null || calories >= maxCalories2) {
                        Integer temp = maxCalories2;
                        maxCalories2 = calories;
                        maxCalories3 = temp;
                    } else if (maxCalories3 == null || calories >= maxCalories3) maxCalories3 = calories;
                    calories = 0;
                }
                line = reader.readLine();
            }
            reader.close();
            return maxCalories1 + maxCalories2 + maxCalories3;
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a input filename: ");
        String filename = sc.nextLine();

        System.out.println(getMaxCaloriePart1(filename));
        System.out.println(getMaxCaloriePart2(filename));

    }


}
