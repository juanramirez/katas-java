import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordValidator {

    static boolean check(String password) {
        Pattern capitalLettersPattern = Pattern.compile("[A-Z]");
        Pattern lowercaseLettersPattern = Pattern.compile("[a-z]");
        Pattern numbersPattern = Pattern.compile("[0-9]");

        Matcher capitalLettersMatcher = capitalLettersPattern.matcher(password);
        Matcher lowercaseLettersMatcher = lowercaseLettersPattern.matcher(password);
        Matcher numbersMatcher = numbersPattern.matcher(password);

        return password.length() > 8
                && capitalLettersMatcher.find()
                && lowercaseLettersMatcher.find()
                && numbersMatcher.find();
    }
}