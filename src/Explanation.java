public class Explanation extends ActivityType {

    public Explanation(String text) {
        super.setText(text);
    }

    public String getText() {
        return super.getText();
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "explanation=" + super.getText() + '\'' +
                "}\n";
    }

}
