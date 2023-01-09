package br.com.rtech.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testCourseNameValid() {
        try {
            new Course("Java POO", "java", 10, "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNullCourseName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course(null, "java", 10, "Ploop"));
    }

    @Test
    public void testCourseNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("", "java", 10, "Ploop"));
    }

    @Test
    public void testCourseNameBlankSpace() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("     ", "java", 10, "Ploop"));
    }

    @Test
    public void testCourseNameUpperCase() {
        try {
            new Course("JAVA POO","java",10,"Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testCourseNameLowerCase() {
        try {
            new Course("java poo","java",10,"Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testCourseNameWithSpecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("%$@%$%java poo","java",10,"Ploop"));
    }

    @Test
    public void testCourseNameWithNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("1234Java poo","java",10,"Ploop"));
    }

    @Test
    public void testValidCode() {
        try {
            new Course("Java POO", "java-poo", 10, "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNullCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                null,
                10,
                "Ploop"));
    }

    @Test
    public void testEmptyCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "",
                10,
                "Ploop"));
    }

    @Test
    public void testCodeWithBlankSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "    ",
                10,
                "Ploop"));
    }

    @Test
    public void testCodeUpperCase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java poo",
                "ABCDE",
                10,
                "Ploop"));
    }

    @Test
    public void testCodeLowerCase() {
        try {
            new Course("Java poo", "abcde", 10, "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void testCodeEspecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java poo",
                "!@#$abcde-123",
                10,
                "Ploop"));
    }

    @Test
    public void testValidNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java POO", "java-poo", 10, "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNegativeNumberEstimatedTimeCourseCompletion() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "java-poo",
                -1,
                "Ploop"));
    }

    @Test
    public void testMinNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java Poo",
                    "java-poo",
                    1,
                    "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testMaxNumberEstimatedTimeCourseCompletion() {
        try {
            new Course("Java Poo",
                    "java-poo",
                    20,
                    "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNumberEstimatedTimeCourseCompletionOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Course("Java Poo",
                "java-poo",
                21,
                "Ploop"));
    }

    @Test
    public void testValidInstructorName() {
        try {
            new Course("Java POO", "java-poo", 10, "Ploop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNullInstructorName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, null));
    }

    @Test
    public void testEmptyInstructorName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, ""));
    }

    @Test
    public void testInstructorNameWithBlankSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, "     "));
    }

    @Test
    public void testInstructorNameSpecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, "%¨&*#&Ploop"));
    }

    @Test
    public  void testInstructorNameWithNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Course("Java POO", "java-poo", 10, "1234Ploop"));
    }
}
