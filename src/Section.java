public class Section {

    private String name;
    private String code;
    private int order;
    private boolean inactive;
    private boolean test;
    private Course course;

    public Section(String name, String code, Course course) {
        Validate.validateWordNotNull(name, ErrorMessage.SECTION_NAME);
        Validate.validateCode(code, ErrorMessage.SECTION_CODE);
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isInactive() {
        return this.inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isTest() {
        return this.test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public Course getCourse() {
        return this.course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", inactive=" + inactive +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
