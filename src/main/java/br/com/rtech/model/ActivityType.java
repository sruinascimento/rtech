package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public abstract class ActivityType {

    private String text;

    public ActivityType(String text) {
        Validate.validateText(text, "[a-zA-Zç\\s^~´]{3,}", ErrorMessage.ACTIVITY_TYPE_TEXT.getMessage());

//        Validate.validateWord(text,  ErrorMessage.ACTIVITY_TYPE_TEXT);
        this.text = text;
    }
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.ActivityType{" +
                "text='" + text + '\'' +
                '}';
    }
}
