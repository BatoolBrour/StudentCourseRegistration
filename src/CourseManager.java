import java.util.ArrayList;

public class CourseManager {

    ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {

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