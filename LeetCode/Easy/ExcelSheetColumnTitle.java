package LeetCode.Easy;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber != 0) {
            int r = columnNumber % 26;
            r = r == 0 ? 25 : r - 1;
            char c = (char) ('A' + r);
            result.append(c);
            columnNumber -= 1;
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
