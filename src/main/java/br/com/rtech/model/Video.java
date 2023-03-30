package br.com.rtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video extends ActivityType {

    @Column(name = "minutes")
    private int minutes;
    @Column(name = "description_video", columnDefinition = "TEXT")
    private String description;

    public Video(String url) {
        super(url);
    }

    public Video() {
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
