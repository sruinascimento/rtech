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

        //segunda forma
//        try {
//            new Category(null, "a123");
//            Assertions.fail();
//        } catch (IllegalArgumentException exception) {
//            Assertions.assertTrue(ErrorMessage.CATEGORY_NAME.getMessage().equals(exception.getMessage()));
//        }
    }

    @Test
    public void testNameWithBlankSpace() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("  ", "a123"));
    }

    @Test
    public void testNullCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", null));
    }

    @Test
    public void testCodeWithBlankSpace() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "   "));
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
    public void testCodeInvalidFormatUpperCase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "AAAA"));
    }

    @Test
    public void testCodeInvalidFormatEspecialCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Category("Javinha", "!@##$"));
    }

}
