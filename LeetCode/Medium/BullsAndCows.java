package LeetCode.Medium;

import java.util.HashMap;

public class BullsAndCows {

    public String getHint(String secret, String guess) {

        HashMap<Character, Integer> digFreq = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i))
                digFreq.put(secret.charAt(i), digFreq.getOrDefault(secret.charAt(i), 0) + 1);
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else if (secret.charAt(i) != guess.charAt(i) && digFreq.getOrDefault(guess.charAt(i), 0) != 0) {
                cows++;
                digFreq.put(guess.charAt(i), digFreq.get(guess.charAt(i)) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {

    }

}
