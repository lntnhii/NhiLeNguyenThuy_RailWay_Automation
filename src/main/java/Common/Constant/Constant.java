package Common.Constant;

import Common.Common.Utilities;
import Common.WebDriverManager.WebDriverManager;

public class Constant {
    public static WebDriverManager WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/";

    //Title
    public static final String LOGIN = "Login";
    public static final String BOOK_TICKET = "Book Ticket";
    public static final String HOME = "Home";
    public static final String REGISTRATION_CONFIRM = "Registration Confirmation Page";
    public static final String SERVER_ERROR_MAILBOX = "Mailbox unavailable";
    public static final String TICKET_PRICE = "Ticket Price";

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

    //Book ticket
    public static final int DATA_NUMBER_OF_DAYS_AFTER = 5;
    public static final String DATA_DEPART_DATE = Utilities.plusDateFromToday(DATA_NUMBER_OF_DAYS_AFTER);
    public static final String DATA_DEPART_FROM = "Sài Gòn";
    public static final String DATA_ARRIVE_AT = "Nha Trang";
    public static final String DATA_SEAT_TYPE = "Soft bed with air conditioner";
    public static final String DATA_TICKET_AMOUNT = "1";
    public static final String MSG_BOOKED_SUCCESSFULLY = "Ticket Booked Successfully!";

    //Timetable
    public static final String DATA_TIMETABLE_DEPART_FROM = "Đà Nẵng";
    public static final String DATA_TIMETABLE_ARRIVE_AT = "Sài Gòn";

    //Ticket price
    public static final String DATA_HEADER_TICKET_PRICE = "Ticket price from Đà Nẵng to Sài Gòn";
    public static final String DATA_HS_PRICE = "310000";
    public static final String DATA_SS_PRICE = "335000";
    public static final String DATA_SSC_PRICE = "360000";
    public static final String DATA_HB_PRICE = "410000";
    public static final String DATA_SB_PRICE = "460000";
    public static final String DATA_SBC_PRICE = "510000";

    //My ticket
    public static final String DATA_CANCEL_ROW = "1";
    public static String DATA_CANCEL_ID;
}
