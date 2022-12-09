package work;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Test{}";
    }

    public void mapMaker(List<String> records, int year) {
        String yearToString = Integer.toString(year);

        Map<String, String> stringStringMap = records.stream()
                .map(str -> str.split(":"))
                .filter(z -> z[1].equals(yearToString))
                .collect(Collectors.toMap(a -> a[0], a -> a[1], (a1, a2) -> a1));

        long result = stringStringMap.size();
                System.out.println(result);

//        List<String> collect1 = collect.stream()
//                .flatMap(l -> Arrays.stream(l))
//                .collect(Collectors.toList());
//        System.out.println(collect1);
//
//        Map<String, Integer> stringIntegerMap = new HashMap<>();
//        for(int i = 0; i < collect1.size(); i++) {
//            stringIntegerMap.();
//
//            }
//        }


//        long count = map.entrySet()
//                .stream()
//                .filter(e -> e.getValue().equals(year))
//                .peek(System.out::println)
//                .map(Map.Entry::getKey)
//                .peek(System.out::println)
//                .count();
    }
}

class Usage {
    public static void main(String[] args) {
        Test sam = new Test();
        List<String> basicRecords = List.of("John Stevenson:2020", "Bruce Cage:2015",
                "Britney Johns:2005", "Brad Wang:2005", "Lee Stone:2011",
                "Rickie Garrison:2015", "Taras Kozak:2017", "John Stevenson:2015",
                "Bart Swan:2018", "Brad Wang:2005", "John Stevenson:2015");
        sam.mapMaker(basicRecords, 2015);
    }
}
