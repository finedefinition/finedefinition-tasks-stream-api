package datetimeapi;

public class Test {
    public static void main(String[] args) {
        DateTimeApi dateTimeApi = new DateTimeApi();
        dateTimeApi.todayDate(DateTimePart.YEAR);
        System.out.println("---------------------------");
        Integer[] array = new Integer[]{2022, 10, 12};
        System.out.println(dateTimeApi.getDate(array));
    }
}
