public abstract class Activity {

    private String title;
    private String code;
    private boolean inactive;
    private String type;
    private Section section;

    public Activity(String title, String code, Section section) {
        Validate.validateName(title, ErrorMessage.ERROR_MESSAGE_NAME.getErrorMessage());
        Validate.validateCode(code, ErrorMessage.ERROR_MESSAGE_CODE.getErrorMessage());
        this.title = title;
        this.code = code;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", inactive=" + inactive +
                ", type='" + type + '\'' +
                ", section=" + section +
                '}';
    }
}
