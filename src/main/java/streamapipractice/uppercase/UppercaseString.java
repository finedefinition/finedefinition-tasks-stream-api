package streamapipractice.uppercase;
/*
Implement a method getUppercaseString() that accepts an array of strings sourceStrings
and returns a list of strings where:

every string starts with a lowercase letters 'a' or 'b'
every string length is at least 3
Return these strings in uppercase.

Examples:

[Input]: new String[]{"b"}
[Result]: List.of();

[Input]: new String[]{"abc"}
[Result]: List.of("ABC");

[Input]: new String[]{"aaa", "bbbb", "ccccc"}
[Result]: List.of("AAA", "BBBB")
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UppercaseString {
    public static List<String> getUppercaseString(String[] sourceStrings) {
        return Arrays.stream(sourceStrings)
                .filter(f -> f.length() >= 3)
                .filter(f -> f.charAt(0) == 'a' || f.charAt(0) == 'b')
                .map(String::toUpperCase)
                .collect(toList());

    }
    }
    class Test {
        public static void main(String[] args) {
            UppercaseString uppercaseString = new UppercaseString();
            String[] a = new String[]{};
            String[] a1 = new String[]{"a"};
            String[] a2 = new String[]{"b"};
            String[] a3 = new String[]{"api"}; // API
            String[] a4 = new String[]{"dba", "bbbb", "bcd"}; // "BBBB", "BCD"
            String[] a5 = new String[]{"Bacd", "Abcd"};
            String[] a6 = new String[]{"aaa", "bbb", "aaa", "bbb"}; //"AAA", "BBB", "AAA", "BBB"
            String[] a7 = new String[]{"a", "aa", "aaa", "b", "bb", "bbb"}; // "AAA", "BBB"
            String[] a8 = new String[]{"aAaAaA"}; // AAAAAA
            System.out.println(UppercaseString.getUppercaseString(a));
            System.out.println(UppercaseString.getUppercaseString(a1));
            System.out.println(UppercaseString.getUppercaseString(a2));
            System.out.println(UppercaseString.getUppercaseString(a3));
            System.out.println(UppercaseString.getUppercaseString(a4));
            System.out.println(UppercaseString.getUppercaseString(a5));
            System.out.println(UppercaseString.getUppercaseString(a6));
            System.out.println(UppercaseString.getUppercaseString(a7));
            System.out.println(UppercaseString.getUppercaseString(a8));
        }
    }

