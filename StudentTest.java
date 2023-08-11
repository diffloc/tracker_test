package tracker;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testValidFirstName() {
        assertDoesNotThrow(() -> new Student("John", "Doe", "john@example.com"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John123", "Doe", "john@example.com"));
    }

    @Test
    public void testGetCoursePointsString() {
        Student student = new Student("Jane", "Doe", "jane@example.com");
        Map<Course, Integer> coursePoints = new EnumMap<>(Course.class);
        coursePoints.put(Course.JAVA, 12);
        coursePoints.put(Course.DSA, 13);
        coursePoints.put(Course.DATABASES, 14);
        coursePoints.put(Course.SPRING, 15);
        student.addCoursePoints(coursePoints);

        assertEquals("JAVA=12; DSA=13; DATABASES=14; SPRING=15", student.getCoursePointsString());
    }
}
