public class Validate {

    public static void validateName(String word, String errorMessage) {
        if (isEmptyOrNull(word)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateCode(String word, String errorMessage) {
        if (isEmptyOrNull(word)) {
            throw new IllegalArgumentException(errorMessage);
        }

        if (!word.matches("[a-z-0-9]+")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isEmptyOrNull(String word) {
        return word == null || word.isEmpty() || word.isBlank();
    }

    public static void validateNumberRange(int number, String erroMessage) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException(erroMessage);
        }
    }
    
}
