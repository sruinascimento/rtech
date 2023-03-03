package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public class Question extends ActivityType {

    private OptionQuestion type = OptionQuestion.MULTIPLES_CHOICES;

    public Question(String enunciate) {
        super(enunciate);
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
