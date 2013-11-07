package com.kadet.vehicleRental.viewEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationForm {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public RegistrationForm(String login, String password, String name, String surname, String phone) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }
}
