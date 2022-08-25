public class Question extends Activity {

    private String formulation;
    private String type;

    public Question(String title, String code, Section section, String formulation) {
        super(title, code, section);
        this.formulation = formulation;
        this.type = "unique answer";
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        Validate.validateQuestionType(type, ErrorMessage.ERROR_MESSAGE_QUESTION_TYPE.getErrorMessage());
        this.type = type;
    }
    
}
