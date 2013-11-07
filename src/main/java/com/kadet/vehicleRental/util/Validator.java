package com.kadet.vehicleRental.util;

import com.kadet.vehicleRental.viewEntity.LogInForm;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public final class Validator {

    public static boolean validRegistrationForm (RegistrationForm form) {
        String login = form.getLogin();
        String password = form.getPassword();
        String name = form.getName();
        String surname = form.getSurname();
        String phone = form.getPhone();
        return login != null
                && password != null
                && name != null
                && surname != null
                && phone != null
                && !"".equals(login.trim())
                && !"".equals(password.trim())
                && !"".equals(name)
                && !"".equals(surname)
                && !"".equals(phone);
    }

    public static boolean validLogInForm (LogInForm form) {
        String login = form.getLogin();
        String password = form.getPassword();
        return login != null
                && password != null
                && !"".equals(login.trim())
                && !"".equals(password.trim());
    }
}
