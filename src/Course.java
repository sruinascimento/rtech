public class Course {

    private String name;
    private String code;
    private double estimatedTimeCourseCompletion;
    private boolean visibility;
    private String targetPublic;
    private String instructorsName;


    public Course(String name, String code) {
        this.toValidateArgumentsInput(name, code);
        this.name = name;
        this.code = code;

    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "ok";
    }

    private void toValidateArgumentsInput(String name, String code) {
        //Refatorar para ENUMS
        final String ERROR_MESSAGE_NAME = "Nome inválido.";
        final String ERROR_MESSAGE_CODE = "Código inválido.";
        Validate.validateName(name, ERROR_MESSAGE_NAME);
        Validate.validateCode(code, ERROR_MESSAGE_CODE);

    }
}
