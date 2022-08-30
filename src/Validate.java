public class Validate {


    //Chamar as mensagens de erro, sem precisar passar por parâmetro?
    public static void validateWordNotNull(String word, String errorMessage) {
        if (isEmptyOrNull(word)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateCode(String word, String errorMessage) {
        if (isEmptyOrNull(word) || !word.matches( "[a-z0-9]+[a-z-0-9]*[a-z0-9]") ) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isEmptyOrNull(String word) {
        return word == null || word.isEmpty() || word.isBlank();
    }

    public static void validateNumberRange(int number, String erroMessage) {
        if (number < 1 || number > 20) {
            throw new IllegalArgumentException(erroMessage);
        }
    }

    public static void validateNameInstructor(String nameInstructor, String errorMessage) {
        if (isEmptyOrNull(nameInstructor)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateQuestionType(String typeQuestion, String errorMessage) {

        if (!typeQuestion.equals("multiples choices") && !typeQuestion.equals("true or false")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateHtmlColorHexadecimal(String htmlColor, String erroMesssage) {
        if (!htmlColor.matches("#[A-F0-9]{6}")) {
            throw new IllegalArgumentException(erroMesssage);
        }
    }
    
}
