public class Main {

    public static void main(String[] args) {

        CourseManager manager = new CourseManager();

        // FR-01: Add students
        Student st1 = new Student("S001", "Menatallah Mahmoud", "mena@example.com");
        Student st2 = new Student("S002", "Batool Brour", "batool@example.com");
        manager.addStudent(st1);
        manager.addStudent(st2);

        // FR-02: Add courses
        Course c1 = new Course("CS101", "Programming", 3, true);
        Course c2 = new Course("CS102", "Database", 3, true);
        Course c3 = new Course("CS103", "Networks", 3, false);

        manager.addCourse(c1);
        manager.addCourse(c2);
        manager.addCourse(c3);

        // FR-03: Display available courses
        manager.displayAvailableCourses();

        // FR-04: Register students in courses
        manager.registerStudent("S001", "CS101");
        manager.registerStudent("S001", "CS102");
        manager.registerStudent("S001", "CS103"); // Should reject: not available
        manager.registerStudent("S001", "CS101"); // Should reject: already registered

        // FR-05: Display registered courses
        manager.displayRegisteredCourses("S001");
        manager.displayRegisteredCourses("S002"); // Should show no courses registered
    }
}