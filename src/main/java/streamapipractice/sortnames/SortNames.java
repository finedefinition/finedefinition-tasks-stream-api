package streamapipractice.sortnames;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of names in format List<String>. Your task is to sort names alphabetically
and return the first three names after sorting.

For example:

[Input] - List.of("Rick", "Jessie", "George", "Garold");
[Result] - List.of("Garold", "George", "Jessie");

[Input] - List.of("Rick");
[Result] - List.of("Rick");

IMPORTANT! You should solve this task using Stream API only.
 */
public class SortNames {

    public static List<String> sortNames(List<String> names) {
        return names.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }
}
