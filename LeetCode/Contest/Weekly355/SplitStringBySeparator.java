package LeetCode.Contest.Weekly355;

import java.util.ArrayList;
import java.util.List;

public class SplitStringBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

//        List<String> result = new ArrayList<>();
//        for (String x : words) {
//            String[] split = x.split(Pattern.quote(String.valueOf(separator)));
//            for (String y : split) {
//                if (!y.equals(""))
//                    result.add(y);
//            }
//        }
//        return result;
//        List<String> result = new ArrayList<>();
//        for (String x : words) {
//            int start = 0;
//            int end;
//            while ((end = x.indexOf(separator, start)) != -1) {
//                String token = x.substring(start, end).trim();
//                if (!token.isEmpty()) {
//                    result.add(token);
//                }
//                start = end + 1;
//            }
//            String lastToken = x.substring(start).trim();
//            if (!lastToken.isEmpty()) {
//                result.add(lastToken);
//            }
//        }
//        return result;
        List<String> result = new ArrayList<>();
        for (String x : words) {
            String[] split = x.split(String.format("\\%c",separator));
            for (String y : split) {
                if (!y.trim().isEmpty()) {
                    result.add(y.trim());
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        String[] words = {"one.two.three", "four.five", "six"};
        System.out.println(new SplitStringBySeparator().splitWordsBySeparator(List.of(words), '.'));
    }

}
