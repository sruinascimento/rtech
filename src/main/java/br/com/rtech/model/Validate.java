package br.com.rtech.model;

public class Validate {
    public static void validateWord(String word, ErrorMessage errorMessage) {
        if (isEmptyOrNull(word) || !word.matches( "[a-zA-Zç\\s^~´]{3,}")) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateCode(String word, ErrorMessage errorMessage) {
        if (isEmptyOrNull(word) || !word.matches( "[a-z0-9]+[a-z-0-9]*[a-z0-9]") ) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static boolean isEmptyOrNull(String word) {
        return word == null || word.isEmpty() || word.isBlank();
    }

    public static void validateNumberRange(int number, ErrorMessage erroMessage) {
        if (number < 1 || number > 20) {
            throw new IllegalArgumentException(erroMessage.getMessage());
        }
    }

    public static void validateNameInstructor(String nameInstructor, ErrorMessage errorMessage) {
        if (isEmptyOrNull(nameInstructor)) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateQuestionType(String typeQuestion, ErrorMessage errorMessage) {

        if (!typeQuestion.equals("multiples choices") && !typeQuestion.equals("true or false")) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateHtmlColorHexadecimal(String htmlColor, ErrorMessage erroMesssage) {
        if (!htmlColor.matches("#[A-Fa-f0-9]{6}")) {
            throw new IllegalArgumentException(erroMesssage.getMessage());
        }
    }
    
}
