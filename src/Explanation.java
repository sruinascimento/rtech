public class Explanation extends Activity {

    private String text;

    public Explanation(String title, String code, Section section, String text) {
        super(title, code, section);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntext=" + text;
    }
}
