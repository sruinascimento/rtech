package br.com.rtech.model;
public class Explanation extends ActivityType {

    public Explanation(String text) {
        super(text);
    }

    public String getText() {
        return super.getText();
    }

    @Override
    public String toString() {
        return "Explanation=" + super.getText() + '\'' + "}";
    }

}
