package main.java.br.com.rtech.model;
public class Explanation extends ActivityType {

    public Explanation(String text) {
        super.setText(text);
    }

    public String getText() {
        return super.getText();
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Explanation{" +
                "explanation=" + super.getText() + '\'' +
                "}";
    }

}
