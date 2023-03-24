package br.com.rtech.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class CourseTest {

    @Test
    public void testCourseNameValid() {
        try {
            new Course("Java POO", "java", 10, new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNullCourseName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course(null, "java", 10, new Instructor("Ploop")));
    }

    @Test
    public void testCourseNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Course("", "java", 10, new Instructor("Ploop")));
    }

    @Test
    public void testCourseNameBlankSpace() {
        assertThrows(IllegalArgumentException.class, () -> new Course("     ", "java", 10, new Instructor("Ploop")));
    }

    @Test
    public void testCourseNameUpperCase() {
        try {
            new Course("JAVA POO","java",10,new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCourseNameLowerCase() {
        try {
            new Course("java poo","java",10,new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCourseNameWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Course("%$@%$%java poo","java",10,new Instructor("Ploop")));
    }

    @Test
    public void testCourseNameWithNumbers() {
        assertThrows(IllegalArgumentException.class, () -> new Course("1234Java poo","java",10,new Instructor("Ploop")));
    }

    @Test
    public void testValidCode() {
        try {
            new Course("Java POO", "java-poo", 10, new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNullCode() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                null,
                10,
                new Instructor("Ploop")));
    }

    @Test
    public void testEmptyCode() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "",
                10,
                new Instructor("Ploop")));
    }

    @Test
    public void testCodeWithBlankSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "    ",
                10,
                new Instructor("Ploop")));
    }

    @Test
    public void testCodeUpperCase() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java poo",
                "ABCDE",
                10,
                new Instructor("Ploop")));
    }

    @Test
    public void testCodeLowerCase() {
        try {
            new Course("Java poo", "abcde", 10, new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }
    @Test
    public void testCodeEspecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java poo",
                "!@#$abcde-123",
                10,
                new Instructor("Ploop")));
    }

    @Test
    public void testValidNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java POO", "java-poo", 10, new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNegativeNumberEstimatedTimeCourseCompletion() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "java-poo",
                -1,
                new Instructor("Ploop")));
    }

    @Test
    public void testMinNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java Poo",
                    "java-poo",
                    1,
                    new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testMaxNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java Poo",
                    "java-poo",
                    20,
                    new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNumberEstimatedTimeCourseCompletionOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "java-poo",
                21,
                new Instructor("Ploop")));
    }

    @Test
    public void testValidInstructorName() {
        try {
            new Course("Java POO", "java-poo", 10, new Instructor("Ploop"));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNullInstructorName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, new Instructor(null)));
    }

    @Test
    public void testEmptyInstructorName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, new Instructor("")));
    }

    @Test
    public void testInstructorNameWithBlankSpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, new Instructor("     ")));
    }

}
