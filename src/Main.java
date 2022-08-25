public class Main {

    public static void main(String[] args) {
        try {

            Course c1 = new Course("Programming", "c01", 4, "--");
            System.out.println(c1);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        System.out.println("Após o tratamento de erros");
    }
}
