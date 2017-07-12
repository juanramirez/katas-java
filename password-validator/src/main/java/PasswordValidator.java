import java.util.regex.Pattern;

class PasswordValidator {
    static boolean isValid(String password) {
        return hasMoreThanEightCharacters(password)
                && hasACapitalLetter(password)
                && hasALowercaseLetter(password)
                && hasANumber(password)
                && hasAnUnderscore(password);
    }

    private static boolean hasMoreThanEightCharacters(String password) {
        return password.length() > 8;
    }

    private static boolean hasAnUnderscore(String password) {
        return hasPattern(password, "_");
    }

    private static boolean hasANumber(String password) {
        return hasPattern(password, "[0-9]");
    }

    private static boolean hasALowercaseLetter(String password) {
        return hasPattern(password, "[a-z]");
    }

    private static boolean hasACapitalLetter(String password) {
        return hasPattern(password, "[A-Z]");
    }

    private static boolean hasPattern(String password, String pattern) {
        return Pattern.compile(pattern).matcher(password).find();
    }
}