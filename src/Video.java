public class Video extends Activity {

    private String url;
    private int minutes;
    private String description;

    public Video(String title, String code, Section section, String url) {
        super(title, code, section);
        Validate.validateName(url, ErrorMessage.ERROR_MESSAGE_NAME.getErrorMessage());
    }

    public String getUrl() {
        return url;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
