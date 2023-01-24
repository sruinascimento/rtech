package br.com.rtech.model;

import br.com.rtech.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void testNameValid() {
        try {
            new Category("Ploop", "abcd123");
        } catch (IllegalArgumentException exception) {
            Assertions.fail();
        }
    }

    @Test
    public void testNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category(null, "a123"));
    }

    @Test
    public void testEmptyName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("", "abcde-123"));
    }

    @Test
    public void testNameWithBlankSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("    ", "a123"));
    }

    @Test
    public void testNameUpperCase() {
        try {
            new Category("PHP", "abcd-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNameLowerCase() {
        try {
            new Category("javinha", "abcde-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void testNameSpecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("$java", "abcde123"));
    }

    @Test
    public  void testNameWithNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("123", "abcde123"));
    }

    @Test
    public void testCodeValid() {
        try {
            new Category("Javinha", "abc-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testNullCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", null));
    }
    @Test
    public void testEmptyCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", ""));
    }
    @Test
    public void testCodeBlankSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "   "));
    }

    @Test
    public void testCodeWithNumbers() {
        try {
            new Category("Java poo", "12334");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void testCodeUpperCase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "AAAA"));
    }
    @Test
    public void testCodeLowerCase() {
        try {
            new Category("Javinha", "abcde");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    public void testCodeSpecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "!@##$"));
    }

}
