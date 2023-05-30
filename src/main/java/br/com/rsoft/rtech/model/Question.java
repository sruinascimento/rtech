package br.com.rsoft.rtech.model;

import br.com.rsoft.rtech.validation.Validate;
import jakarta.persistence.*;
@Entity
@Table(name = "question")
public class Question extends ActivityType {
    @Column(name = "type_question")
    @Enumerated(EnumType.STRING)
    private OptionQuestion type;

    public Question(String enunciate) {
        super(enunciate);
        type = OptionQuestion.MULTIPLES_CHOICES;
    }

    public Question() {
    }

    public OptionQuestion getType() {
        return type;
    }

    public void setType(OptionQuestion type) {
        Validate.validateQuestionType(type, ErrorMessage.QUESTION_TYPE.getMessage());
        this.type = type;
    }

    @Override
    public String toString() {
        return "Question{" +
                "enunciate='" + super.getText()+ '\'' +
                " type='" + type + '\'' +
                '}';
    }
}
