package br.com.rtech.model;

import br.com.rtech.validation.Validate;
import jakarta.persistence.*;


@Entity
@Table(name = "activity_type")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_activity_type", columnDefinition = "TEXT")
    private String text;

    public ActivityType(String text) {
        Validate.validateText(text, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.ACTIVITY_TYPE_TEXT.getMessage());
        this.text = text;
    }

    public ActivityType() {
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "text='" + text + '\'' +
                '}';
    }
}
