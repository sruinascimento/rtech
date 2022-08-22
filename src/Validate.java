public class Validate {

    public static void validateName(String wordToBeValidate, String errorMessage) {
        if (isEmptyOrNull(wordToBeValidate)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateCode(String wordToBeValidate, String errorMessage) {
        if (isEmptyOrNull(wordToBeValidate)) {
            throw new IllegalArgumentException(errorMessage);
        }

        if (!wordToBeValidate.matches("[a-z-0-9]+")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isEmptyOrNull(String word) {
        return word == null || word.isEmpty() || word.isBlank();
    }
}
