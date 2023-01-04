package main.java.br.com.rtech.model;

public class Question extends ActivityType {

    private String type = "unique answer";

    public Question(String enunciate) {
        super.setText(enunciate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        Validate.validateQuestionType(type, ErrorMessage.QUESTION_TYPE);
        this.type = type;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Question{" +
                "enunciate='" + super.getText()+ '\'' +
                " type='" + type + '\'' +
                '}';
    }
}
