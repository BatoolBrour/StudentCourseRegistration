public class Main {

    public static void main(String[] args) {

        CourseManager manager = new CourseManager();

        Course c1 = new Course("CS101", "Programming", 3, true);
        Course c2 = new Course("CS102", "Database", 3, true);
        Course c3 = new Course("CS103", "Networks", 3, false);

        manager.addCourse(c1);
        manager.addCourse(c2);
        manager.addCourse(c3);

        manager.displayAvailableCourses();
    }
}