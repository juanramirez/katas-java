import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordValidator {

    static boolean check(String password) {
        Pattern capitalLettersPattern = Pattern.compile("[A-Z]");
        Matcher capitalLettersMatcher = capitalLettersPattern.matcher(password);

        return password.length() > 8 && capitalLettersMatcher.find();
    }
}