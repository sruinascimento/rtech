package br.com.rtech.model;

public class Activity {

    private String title;
    private String code;
    private boolean active;
    private ActivityType type;
    private Section section;

    public Activity(String title, String code, Section section) {
        Validate.validateWord(title, ErrorMessage.ACTIVITY_NAME);
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
                ", active=" + active +
                ", type='" + type + '\'' +
                ", section=" + section +
                '}';
    }
}
