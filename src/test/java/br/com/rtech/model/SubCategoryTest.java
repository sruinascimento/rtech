package br.com.rtech.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class SubCategoryTest {
      @Test
    public void testNameValid() {
        try {
            new SubCategory("Java poo", "abc123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory(null, "abcd123"));
    }

    @Test
    public void testNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory("", "abcde123"));
    }

    @Test
    public void testNameWithBlankSpace() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory("  ", "asbcde123"));
    }

    @Test
    public void testValidCode() {
       try {
        new SubCategory("Java poo", "abcde-123");
       } catch (IllegalArgumentException exception) {
           exception.printStackTrace();
           Assertions.fail();
       }
    }

    @Test
    public void testNullCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", null));
    }

    @Test
    public void testCodeUpperCase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", "Abcd-123"));
    }

    @Test
    public void testCodeLowerCase() {
        try {
            new SubCategory("Java poo", "abcde");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void testCodeEspecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SubCategory("Java poo", "!@#$abcde-123"));
    }
}
