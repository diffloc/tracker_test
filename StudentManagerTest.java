package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.List;

public class StudentManagerTest {

    @Test
    public void testAddStudent() {
        // Create a StudentManager instance
        StudentManager studentManager = new StudentManager();

        // Create a Student
        Student student = new Student("John", "Doe", "test@test.com");

        // Add the student to the StudentManager
        studentManager.addStudent(student);

        // Get the list of students from the StudentManager
        Set<Student> students = studentManager.getStudents();

        // Assert that the students list contains the added student
        Assertions.assertEquals(1, students.size());
        Assertions.assertTrue(students.contains(student));

        Assertions.assertTrue(studentManager.addStudent(student));
        Assertions.assertFalse(studentManager.addStudent(student)); // Duplicate email should return false
    }

    @Test
    public void testGetStudentByID() {
        // Create a StudentManager instance
        StudentManager studentManager = new StudentManager();

        Student student = new Student("Alice", "Smith", "alice@example.com");
        studentManager.addStudent(student);

        Assertions.assertNull(studentManager.getStudentByID(999)); // Non-existing ID
        Assertions.assertEquals(student, studentManager.getStudentByID(student.getStudentID()));
    }

    @Test
    public void testAddMultipleStudents() {
        // Create a StudentManager instance
        StudentManager studentManager = new StudentManager();

        // Create multiple students
        Student student1 = new Student("John", "Doe", "test1@test.com");
        Student student2 = new Student("Jane", "Smith", "test2@test.com");
        Student student3 = new Student("Alice", "Johnson", "test3@test.com");

        // Add the students to the StudentManager
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        // Get the list of students from the StudentManager
        Set<Student> students = studentManager.getStudents();

        // Assert that the students list contains all the added students
        Assertions.assertEquals(3, students.size());
        Assertions.assertTrue(students.contains(student1));
        Assertions.assertTrue(students.contains(student2));
        Assertions.assertTrue(students.contains(student3));
    }

    @Test
    public void testEmptyStudentManager() {
        // Create a StudentManager instance
        StudentManager studentManager = new StudentManager();

        // Get the list of students from the StudentManager
        Set<Student> students = studentManager.getStudents();

        // Assert that the students list is initially empty
        Assertions.assertTrue(students.isEmpty());
    }

    // Add more tests for other methods in StudentManager if applicable

}
