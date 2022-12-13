package streamapimedium;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiMedium {
    /**
     * Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}.
     * Return number of unique persons who have visited hospital during the given year (second input param).
     * Be careful, because one person may visit a hospital several times per year and for each visit new record
     * will be generated. Result shouldn't contain duplicates.
     */
    public Long getVisitorsPerYear(List<String> records, int year) {
        String yearToString = Integer.toString(year);

        Map<String, String> stringStringMap = records.stream()
                .map(str -> str.split(":"))
                .filter(z -> z[1].equals(yearToString))
                .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));

        long result = stringStringMap.size();
        return result;
//        Map<String, Integer> map =  records.stream()
//                .peek(System.out::println)
//                .map(str -> str.split(":"))
//                .peek(System.out::println)
//                .collect(Collectors.toMap(str -> str[0], str -> Integer.getInteger(str[1])));
//        System.out.println(map);
//        long count = map.entrySet()
//                .stream()
//                .filter(e -> e.getValue().equals(year))
//                .peek(System.out::println)
//                .map(Map.Entry::getKey)
//                .peek(System.out::println)
//                .count();
//
//
//        return count;
    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"  (String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
     * Output : {"Odyssey", "Sun.ltd"}
     */
    public List<String> getCompanies(Map<String, Integer> input) {
        return input.entrySet()
                .stream()
                .filter(f -> f.getValue() > 0)
                .map(b -> b.getKey())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of integer numbers, convert each integer into its' binary representation in string format
     * and join all of them into a single string and putting each value into brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * (1)
     * (10100)
     * (100001)
     */
    public String convertAndModifyNumbers(List<Integer> numbers) {
        String collect = numbers.stream()
                .map(i -> "(" + Integer.toBinaryString(i) + ")")
                .collect(Collectors.joining("\n"));
        return collect;
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public String charsIncrementation(String string, int increment) {
        return string.chars()
                .boxed()
                .mapToInt(i -> i + increment)
                .mapToObj(o -> (char) o)
                .map(c->c.toString()).
                collect(Collectors.joining());
    }

    /**
     * Given List of string where each element represents persons' age and name:
     * {"99:Johny", "20:Brad", ...} return the age of the oldest person
     */
    public Long getOldestPersonAge(List<String> people) {
        return people.stream()
                .map(str -> str.split(":"))
                .map(f -> Integer.parseInt(f[0]))
                .max((x, y) -> x - y)
                .map(f -> (long) f)
                .get();
    }
}
class Test {
    public static void main(String[] args) {
        List<Integer> positiveNumbers = List.of(1, 3, 5, 8);
        StreamApiMedium sam = new StreamApiMedium();
        System.out.println(sam.convertAndModifyNumbers(positiveNumbers));
        List<String> basicInput = List.of("090:John", "-005:Anthony", "000:Nicolas",
                "037:Brad", "088:Britney", "007:Annie", "091:Jorge", "-120:Bruce",
                "022:Jasper", "001:Cortney", "050:Emily", "047:Naomi", "090:Leonard");
        Map<String, Integer> collect = basicInput.stream()
                .map(str -> str.split(":"))
                .collect(Collectors.toMap(a -> a[1], a -> Integer.getInteger(a[0]), (a1, a2) -> a1));
        System.out.println(collect);

//        List<String> basicRecords = List.of("John Stevenson:2020", "Bruce Cage:2015",
//                "Britney Johns:2005", "Brad Wang:2005", "Lee Stone:2011",
//                "Rickie Garrison:2015", "Taras Kozak:2017", "John Stevenson:2015",
//                "Bart Swan:2018", "Brad Wang:2005", "John Stevenson:2015");
//        System.out.println(sam.getVisitorsPerYear(basicRecords, 2005));
    }
}
