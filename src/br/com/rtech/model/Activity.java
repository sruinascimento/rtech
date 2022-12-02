package br.com.rtech.model;

public class Activity {

    private String title;
    private String code;
    private boolean inactive;
    private ActivityType type;
    private Section section;

    public Activity(String title, String code, Section section) {
        Validate.validateWordNotNull(title, ErrorMessage.ACTIVITY_NAME);
        Validate.validateCode(code, ErrorMessage.ACTIVITY_CODE);
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

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", inactive=" + inactive +
                ", type='" + type + '\'' +
                ", section=" + section +
                '}';
    }
}
