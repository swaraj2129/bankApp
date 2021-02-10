package registeration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to validate username and password for registration
 */
public class Validation {

    public static boolean validUsernameCheck(String toBeMatched){
        String regex = "^[A-Za-z]\\w{4,8}$";
        Pattern username_check = Pattern.compile(regex);
        Matcher m = username_check.matcher(toBeMatched);
        return m.matches();
    }
    public static boolean validPasswordCheck(String toBeMatched){
        String regex = "^[A-Za-z0-9]\\w{4,8}$";
        Pattern username_check = Pattern.compile(regex);
        Matcher m = username_check.matcher(toBeMatched);
        return m.matches();
    }

}
