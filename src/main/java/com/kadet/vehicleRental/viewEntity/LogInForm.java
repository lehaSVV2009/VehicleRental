package com.kadet.vehicleRental.viewEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class LogInForm {

    private String login;
    private String password;

    public LogInForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
