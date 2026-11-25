import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager {

    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    // Maps studentId -> list of registered courses
    Map<String, List<Course>> registrations = new HashMap<>();

    public void addStudent(Student student) {
        if (student == null ||
            student.id == null || student.id.trim().isEmpty() ||
            student.name == null || student.name.trim().isEmpty() ||
            student.email == null || student.email.trim().isEmpty()) {
            System.out.println("Error: Required student fields cannot be empty!");
            return;
        }

        for (Student s : students) {
            if (s.id.equals(student.id)) {
                System.out.println("Error: Student ID already exists!");
                return;
            }
        }

        students.add(student);
        registrations.putIfAbsent(student.id, new ArrayList<>());
        System.out.println("Student added successfully!");
    }

    public void addCourse(Course course) {

        // Check required fields
        if (course == null ||
            course.code == null || course.code.isEmpty() ||
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
        boolean found = false;

        for (Course c : courses) {
            if (c.available) {
                c.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses are currently available.");
        }
    }

    public void registerStudent(String studentId, String courseCode) {
        Student foundStudent = null;
        for (Student s : students) {
            if (s.id.equals(studentId)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        Course foundCourse = null;
        for (Course c : courses) {
            if (c.code.equals(courseCode)) {
                foundCourse = c;
                break;
            }
        }

        if (foundCourse == null) {
            System.out.println("Error: Course not found!");
            return;
        }

        if (!foundCourse.available) {
            System.out.println("Error: Course is not available for registration!");
            return;
        }

        registrations.putIfAbsent(studentId, new ArrayList<>());
        List<Course> studentCourses = registrations.get(studentId);

        for (Course c : studentCourses) {
            if (c.code.equals(courseCode)) {
                System.out.println("Error: Student is already registered in this course!");
                return;
            }
        }

        studentCourses.add(foundCourse);
        System.out.println("Registration confirmed for student " + studentId + " in course " + courseCode + ".");
    }

    public void displayRegisteredCourses(String studentId) {
        Student foundStudent = null;
        for (Student s : students) {
            if (s.id.equals(studentId)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        List<Course> studentCourses = registrations.get(studentId);
        System.out.println("\nRegistered Courses for Student " + studentId + ":");

        if (studentCourses == null || studentCourses.isEmpty()) {
            System.out.println("No courses are registered for this student.");
            return;
        }

        for (Course c : studentCourses) {
            c.displayInfo();
        }
    }
}