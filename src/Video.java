public class Video extends ActivityType {

    private int minutes;
    private String description;

    public Video(String url) {
        super.setText(url);
    }

    public String getUrl() {
        return super.getText();
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

    @Override
    public String toString() {
        return "Video{" +
                "url=" + this.getUrl()+
                "minutes=" + minutes +
                ", description='" + description + '\'' +
                '}';
    }
}
