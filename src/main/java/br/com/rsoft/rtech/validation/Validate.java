package br.com.rsoft.rtech.validation;


import br.com.rsoft.rtech.model.OptionQuestion;

import java.util.Arrays;

public class Validate {

    public static void validateText(String text, String regex, String errorMessage) {
        if (isNullOrEmpty(text) || !text.matches(regex)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateNumberRange(int number, int min, int max,String erroMessage) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(erroMessage);
        }
    }

    public static void validateQuestionType(OptionQuestion typeQuestion, String errorMessage) {
        boolean invalidQuestionType = Arrays.stream(OptionQuestion.values()).noneMatch(value -> value.equals(typeQuestion));
        if (invalidQuestionType) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isNullOrEmpty(String word) {
        return word == null || word.isEmpty() || word.isBlank();
    }

}
