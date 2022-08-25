public class Instructor {

    private String name;

    public Instructor(String name) {
        Validate.validateName(name, ErrorMessage.ERROR_MESSAGE_NAME.getErrorMessage());
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return  "#### Instructor ####\n" +
                "Name: " + this.name + "\n";
    }
}
