package streamapipractice.filterandmodifyletters;

import java.util.stream.Collectors;

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

        String s = input.chars()
                .filter(i -> i % 2 != 0)
                .boxed()
                .mapToInt(f -> f)
                .mapToObj(o -> (char) o)
                .map(Object::toString)
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .toString();
        return s;
    }
}
