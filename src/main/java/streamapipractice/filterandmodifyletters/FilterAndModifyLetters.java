package streamapipractice.filterandmodifyletters;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a String input with some random characters. Your task is to
remove every letter having an odd index and return the result in
upper case. Note that input will contain only letters without numbers or punctuation.

Example:

[Input] - "random"
[Result] - "RNO"

[Input] - "a"
[Result] - "A"
 */
public class FilterAndModifyLetters {
    public static String filterLetters(String input) {
       char[] inputArray = input.toCharArray();
        return IntStream.range(0, inputArray.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> inputArray[i])
                .map(Object::toString)
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

    public static String getEvenIndexedStrings(char [] names) {
        return IntStream.range(0, names.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> names[i])
                .map(Object::toString)
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .toString();
    }
}
class Test {
    public static void main(String[] args) {
        String n = "random"; // [R, N, O]
        String n1 = "a"; // [R, N, O]
        String n2 = ""; // [R, N, O]
//        String[] s = new String[] {"r", "a", "n", "d","o","m"}; // [R, N, O]O
        char[] suka = new char[] {'r', 'a', 'n', 'd','o','m'}; // [R, N, O]
        FilterAndModifyLetters filterAndModifyLetters = new FilterAndModifyLetters();
        System.out.println(FilterAndModifyLetters.filterLetters(n));
        System.out.println(FilterAndModifyLetters.filterLetters(n1));
        System.out.println(FilterAndModifyLetters.filterLetters(n2));
        System.out.println(FilterAndModifyLetters.getEvenIndexedStrings(suka));
    }
}
