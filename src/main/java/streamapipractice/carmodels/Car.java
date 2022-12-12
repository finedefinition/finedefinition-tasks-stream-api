package streamapipractice.carmodels;

class Car {
    private int year;
    private String model;

    public Car(int year, String model) {
        this.year = year;
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
}
