package br.com.rtech.model;
public class Instructor {

    private String name;

    public Instructor(String name) {
        Validate.validateWordNotNull(name, ErrorMessage.COURSE_NAME);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return  "#### br.com.rtech.model.Instructor ####\n" +
                "Name: " + this.name + "\n";
    }
}
