package br.com.rtech.model;

public abstract class ActivityType {

    private String text;

    public ActivityType(String text) {
        Validate.validateWord(text,  ErrorMessage.ACTIVITY_TYPE_TEXT);
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
