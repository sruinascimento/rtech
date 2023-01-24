package br.com.rtech.model;

public enum OptionQuestion {
    MULTIPLES_CHOICES("multiples choices"),
    TRUE_OR_FALSE("true or false");
    private String text;

    OptionQuestion(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
