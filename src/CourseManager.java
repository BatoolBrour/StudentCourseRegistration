import java.util.ArrayList;

public class CourseManager {

    ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {

    // Check required fields
    if (course.code == null || course.code.isEmpty() ||
        course.name == null || course.name.isEmpty()) {

        System.out.println("Error: Required fields cannot be empty!");
        return;
    }

    // Validate credit hours
    if (course.creditHours <= 0) {
        System.out.println("Error: Credit hours must be positive!");
        return;
    }

    // Check duplicate course code
    for (Course c : courses) {
        if (c.code.equals(course.code)) {
            System.out.println("Course already exists!");
            return;
        }
    }

    courses.add(course);
    System.out.println("Course added successfully!");
}

    public void displayAvailableCourses() {

        System.out.println("\nAvailable Courses:");

        for (Course c : courses) {
            if (c.available) {
                c.displayInfo();
            }
        }
    }
}