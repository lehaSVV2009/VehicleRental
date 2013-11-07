package com.kadet.vehicleRental.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class Occupier {

    private String name;
    private String surname;
    private String phone;
    private String login;
    private String password;

    public Occupier(String name, String surname, String phone, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
