package streamapipractice.uniquenumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Implement a method getUniqueNumbers() that accepts a string sourceNumber and returns
a list with all unique numbers as chars from this string.

Examples:

[Input]: "1"
[Result]: List.of('1');

[Input]: "4444"
[Result]: List.of('4');

[Input]: "987"
[Result]: List.of('9', '8', '7');
 */
public class UniqueNumbers {
    public static List<Character> getUniqueNumbers(String sourceNumber) {
        return sourceNumber.chars()
                .mapToObj(f -> (char) f)
                .distinct()
                .collect(Collectors.toList());
    }
}

class Test {
    public static void main(String[] args) {
        UniqueNumbers uniqueNumbers = new UniqueNumbers();
        System.out.println(UniqueNumbers.getUniqueNumbers("4444"));
        System.out.println(UniqueNumbers.getUniqueNumbers("1212"));
        System.out.println(UniqueNumbers.getUniqueNumbers("3456"));
        System.out.println(UniqueNumbers.getUniqueNumbers("1"));
        System.out.println(UniqueNumbers.getUniqueNumbers(""));
    }
}
