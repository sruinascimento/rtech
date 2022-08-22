public class Main {

    public static void main(String[] args) {
        try {
            Validate.validateCode("a123-", "código inválido");
            Validate.validateName("Rui", "nome inválido");
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}
