package Common.Constant;

import Common.Common.Utilities;
import Common.WebDriverManager.WebDriverManager;

public class Constant {
    public static WebDriverManager WEBDRIVER = WebDriverManager.getInstance();
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/";

    //Login
    public static final String USERNAME = "lntnhii@gmail.com";
    public static final String PASSWORD = "123456789";

    public static final String DATA_INVALID_PASSWORD = "ahihidongoc";
    public static final String DATA_EMPTY_USERNAME = "";
    public static final int DATA_LOGIN_TIMES = 4;

    public static String MSG_WELCOME_USER = "Welcome %s";
    public static final String MSG_INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String MSG_PROBLEM_USERNAME_PASSWORD = "There was a problem with your login and/or errors exist in your form.";

    //Register
    public static final String DATA_REGISTER_EMAIL = "lntnhii+" + Utilities.randomString() + "@gmail.com";
    public static final String DATA_REGISTER_PASSWORD = "123456789";
    public static final String DATA_REGISTER_CONFIRM_PASSWORD = "123456789";
    public static final String DATA_REGISTER_PID = "123456789";

    public static final String DATA_EMPTY_PASSWORD = "";
    public static final String DATA_EMPTY_CONFIRM_PASSWORD = "";
    public static final String DATA_EMPTY_PID = "";

    public static final String MSG_THANK_YOU_REGISTER = "Thank you for registering your account";
    public static final String MSG_IN_USED_EMAIL = "This email address is already in use.";
    public static final String MSG_CONFIRM_PASSWORD_ERROR = "The password confirmation does not match the new password.";
    public static final String MSG_REGISTER_ERROR = "There're errors in the form. Please correct the errors and try again.";
    public static final String MSG_PASSWORD_ERROR = "Invalid password length";
    public static final String MSG_PID_ERROR = "Invalid ID length";

    //Change password
    public static final String DATA_NEW_PASSWORD = "a123:\"/{}!@$\\";
    public static final String DATA_CONFIRM_PASSWORD = "b456:\"/{}!@$\\";
}
