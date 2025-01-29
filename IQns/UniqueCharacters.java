package IQns;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

    public static int codeHere(StringBuilder inputData) {
        Set<Character> charSet = new HashSet<>();
        for (char x : inputData.toString().toCharArray())
            charSet.add(x);
        return charSet.size();
    }

}
