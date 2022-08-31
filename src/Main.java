public class Main {

    public static void main(String[] args) {
        try {


            //testing Course
            Course programmingJava = new Course("Programming Java", "c01", 8, "Rui");
            programmingJava.setSyllabus("class, methods, atributes");
            programmingJava.setDevelopedSkills("poo and design patterns");
            programmingJava.setTargetPublic("developers");
////            System.out.println(programmingJava);

            var section = new Section("First class", "001", programmingJava);
            section.setOrder(1);
////            System.out.println(section);

            Activity activity = new Activity("homework", "101", section);

            var explanation = new Explanation("homeworke 10 points");
//            System.out.println(explanation);
            var video = new Video("http://www.video.com");
            video.setDescription("Explanation video");
            var question = new Question("Choose the the option which show the class concept");
            question.setType("multiples choices");

            activity.setType(video);
//            System.out.println(activity);

            var alternative = new Alternative("is a template used to create objects and to define object data types and methods.", true, question);
            alternative.setOrder(1);
//            System.out.println(alternative);

            var category = new Category("Programming", "27-c");
            category.setHtmlColorCode("#CCCCCC");
            category.setIconPath("../images/icon.jpg");
//            System.out.println(category);

            var subCategory = new SubCategory("Programming A", "001", category);
//            System.out.println(subCategory);

            programmingJava.setSubCategory(subCategory);
            System.out.println(programmingJava);

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }
}
