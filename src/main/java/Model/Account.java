package Model;

import Common.Common.Utilities;
import Common.Constant.Constant;

public class Account {
    private String email;
    private String password;
    private String confirmPassword;
    private String pid;

    public Account() {
        this.email = Utilities.randomEmail();
        this.password = Constant.DATA_REGISTER_PASSWORD;
        this.confirmPassword = Constant.DATA_REGISTER_CONFIRM_PASSWORD;
        this.pid = Constant.DATA_REGISTER_PID;
    }

    public Account(String email, String password, String confirmPassword, String pid) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pid = pid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPid() {
        return pid;
    }
}
