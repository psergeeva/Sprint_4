import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }


    public boolean checkNameToEmboss() {
        final String PATTERN = "(?=.{3,19}$)^[a-zA-Zа-яА-ЯёЁ]+[\\s][a-zA-Zа-яА-ЯёЁ]+$";
        if (name == null) {
            return false;
        }
        return Pattern.matches (PATTERN, name);
    }

}