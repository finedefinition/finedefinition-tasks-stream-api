package streamapiadvanced;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamApiAdvanced {
    /**
     * Given array of numbers, your task is to sort them in the reverse order and return only those
     * numbers that can be divided by 5 without a remainder.
     */
    public List<Integer> filterAndReverse(int[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .filter(f -> f % 5 == 0)
                .collect(Collectors.toList());
    }

    /**
     * We want to gather some statistics: we have list of people and we want to know
     * distribution among the age of women who have cats and are older than 18
     * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
     * 21 - List.of(person3, person7, ...);
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> people) {
        people.stream()
                .filter(f -> f.getSex() == Person.Sex.WOMAN)
                .filter(f -> f.getAge() >= 18)
                .filter(f -> f.getCatList() != null)
                .collect(Collectors.groupingBy(Person::getAge));


        return Collections.emptyMap();
    }

    /**
     * Given a list of random strings, group all of them by the last letter from the
     * string. If last char is a number or punctuation - skip the word.
     */
    public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
        return Collections.emptyMap();
    }
}
