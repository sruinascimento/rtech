package br.com.rtech.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class SubCategoryTest {

    @Test
    public void testNameValid() {
        try {
            new SubCategory("Java poo", "abc123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory(null, "abcd123"));
    }

    @Test
    public void testNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("", "abcde123"));
    }

    @Test
    public void testNameWithBlankSpace() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("  ", "asbcde123"));
    }

    @Test
    public void testNameUpperCase() {
        try {
            new SubCategory("JAVA PACKAGES", "abc123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }
    @Test
    public void testNameLowerCase() {
        try {
            new SubCategory("java poo", "abc123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNameSpecialCharacters() {
          assertThrows(IllegalArgumentException.class, () -> new SubCategory("#$!*&@", "abcde-123"));
    }

    @Test
    public  void testNameWithNumbers() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("123Java", "abcde123"));
    }

    @Test
    public void testValidCode() {
       try {
        new SubCategory("Java poo", "abcde-123");
       } catch (IllegalArgumentException exception) {
           exception.printStackTrace();
           fail();
       }
    }

    @Test
    public void testNullCode() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", null));
    }

    @Test
    public void testEmptyCode() {
          assertThrows(IllegalArgumentException.class, () -> new SubCategory("", "abcde-123"));
    }

    @Test
    public void testCodeWithBlankSpaces() {
          assertThrows(IllegalArgumentException.class, () -> new SubCategory("    ", "abcde-123"));
    }
    @Test
    public void testCodeUpperCase() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", "Abcd-123"));
    }

    @Test
    public void testCodeWithNumbers() {
        try {
            new SubCategory("Java poo", "12334");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCodeLowerCase() {
        try {
            new SubCategory("Java poo", "abcde");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }
    @Test
    public void testCodeEspecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", "!@#$abcde-123"));
    }
}
