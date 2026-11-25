public class Course {

    String code;
    String name;
    int creditHours;
    boolean available;

    public Course(String code, String name,
                  int creditHours, boolean available) {

        this.code = code;
        this.name = name;
        this.creditHours = creditHours;
        this.available = available;
    }

    public void displayInfo() {
        System.out.println(
            code + " - " + name +
            " - Credit Hours: " + creditHours
        );
    }
}