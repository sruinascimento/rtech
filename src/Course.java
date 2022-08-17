public class Course {

    private String name;
    private int code;
    private double estimatedTimeCourseCompletion;
    private boolean visibility;
    private String targetPublic;
    private String instructorsName;


    public Course(String name, int code) {
        this.name = name;
        this.code = code;

    }

    private void validateName(String name) {
       boolean nameEmpty = name.isEmpty();
       boolean nameNull = name == null;
        if (!nameEmpty && !nameNull) {
            return;
        }
        throw new NullPointerException("Nome inválido");
    }

}
