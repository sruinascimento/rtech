public abstract class ActivityType {

    private String text;

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        Validate.validateWordNotNull(text,  ErrorMessage.ACTIVITY_TYPE_TEXT);
        this.text = text;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "text='" + text + '\'' +
                '}';
    }
}
