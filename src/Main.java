public class Main {

    public static void main(String[] args) {
        try {


            //testing Course
            Course programmingJava = new Course("Programming Java", "c01", 8, "Rui");
            programmingJava.setCourseSyllabus("class, methods, atributes");
            programmingJava.setDevelopedSkills("poo and design patterns");
            programmingJava.setTargetPublic("developers");
//            System.out.println(programmingJava);

            var section = new Section("First class", "001", programmingJava);
            section.setOrder(1);
//            System.out.println(section);

            Activity activity = new Activity("homework", "101", section);

            var explanation = new Explanation("homeworke 10 points");
            System.out.println(explanation);
            var video = new Video("http://www.video.com");
            var question = new Question("Choose the the option which show the class concept");
            question.setType("multiples choices");
            video.setDescription("Explanation video");

            activity.setType(video);
            System.out.println(activity);



        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        System.out.println("Após o tratamento de erros");
    }
}
