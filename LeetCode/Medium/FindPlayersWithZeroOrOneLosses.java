package LeetCode.Medium;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> neitherWinnerNorLosers = new HashSet<>();
        for (int[] match : matches) {
            if (!neitherWinnerNorLosers.contains(match[0])) winners.add(match[0]);
            if (!neitherWinnerNorLosers.contains(match[1]) && !losers.contains(match[1])) {
                losers.add(match[1]);
                winners.remove(match[1]);
            } else {
                neitherWinnerNorLosers.add(match[1]);
                winners.remove(match[1]);
                losers.remove(match[1]);
            }
        }
        List<Integer> winnersList = new ArrayList<>(winners);
        Collections.sort(winnersList);
        List<Integer> losersList = new ArrayList<>(losers);
        Collections.sort(losersList);
        return new ArrayList<>(List.of(winnersList, losersList));
    }

    public static void main(String[] args) {

    }

}
