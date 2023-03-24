package LeetCode.Hard;


import java.util.*;

public class NamingACompany {

    public static long distinctNamesOffl(String[] ideas)
    {
        HashSet<String>[] initialGroup = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            initialGroup[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            initialGroup[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        // Calculate number of valid names from every pair of groups.
        long answer = 0;
        for (int i = 0; i < 25; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                // Get the number of mutual suffixes.
                long numOfMutual = 0;
                for (String ideaA : initialGroup[i]) {
                    if (initialGroup[j].contains(ideaA)) {
                        numOfMutual++;
                    }
                }

                // Valid names are only from distinct suffixes in both groups.
                // Since we can swap a with b and swap b with a to create two valid names, multiple answer by 2.
                answer += 2 * (initialGroup[i].size() - numOfMutual) * (initialGroup[j].size() - numOfMutual);
            }
        }

        return answer;
    }

    public static long distinctNames(String[] ideas) {

        Map<Character, Set<String>> map = new HashMap<>();
        for (String x : ideas) {
            Character ch = x.charAt(0);
            if (map.containsKey(ch)) {
                Set<String> temp = map.get(x.charAt(0));
                temp.add(x.substring(1, x.length()));
                map.put(ch, temp);
            } else {
                Set<String> temp = new HashSet<>();
                temp.add(x.substring(1, x.length()));
                map.put(x.charAt(0), temp);
            }
        }
        long count = 0;
        List<Character> mapKeys = new ArrayList<>(map.keySet());
        for (int i = 0; i < mapKeys.size() - 1; i++) {
            Set<String> set1 = map.get(mapKeys.get(i));
            for (int j = i + 1; j < mapKeys.size(); j++) {
                Set<String> set2 = map.get(mapKeys.get(j));
                Set<String> intersection = new HashSet<>(set1);
                intersection.retainAll(set2);
                count+=((set1.size()-intersection.size())*(set2.size()-intersection.size())*2);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] ideas = {"coffee", "donuts", "time", "toffee", "d"};
        System.out.println(distinctNames(ideas));

    }

}
