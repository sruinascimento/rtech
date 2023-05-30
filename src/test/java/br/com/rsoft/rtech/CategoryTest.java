package br.com.rsoft.rtech;

import br.com.rsoft.rtech.model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class CategoryTest {

    @Test
    public void testNameValid() {
        try {
            new Category("Ploop", "abcd123");
        } catch (IllegalArgumentException exception) {
            fail();
        }
    }

    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(null, "a123"));
    }

    @Test
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Category("", "abcde-123"));
    }

    @Test
    public void testNameWithBlankSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Category("    ", "a123"));
    }

    @Test
    public void testNameUpperCase() {
        try {
            new Category("PHP", "abcd-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNameLowerCase() {
        try {
            new Category("javinha", "abcde-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }
    @Test
    public void testNameSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Category("$java", "abcde123"));
    }

    @Test
    public  void testNameWithNumbers() {
        assertThrows(IllegalArgumentException.class, () -> new Category("123", "abcde123"));
    }

    @Test
    public void testCodeValid() {
        try {
            new Category("Javinha", "abc-123");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testNullCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", null));
    }
    @Test
    public void testEmptyCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", ""));
    }
    @Test
    public void testCodeBlankSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "   "));
    }

    @Test
    public void testCodeWithNumbers() {
        try {
            new Category("Java poo", "12334");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }
    @Test
    public void testCodeUpperCase() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "AAAA"));
    }
    @Test
    public void testCodeLowerCase() {
        try {
            new Category("Javinha", "abcde");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCodeSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "!@##$"));
    }

}
