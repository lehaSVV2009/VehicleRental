package com.kadet.vehicleRental.listeners;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.view.ExtJButton;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class RegistrateListener implements ActionListener {

    private JTextField login;
    private JTextField password;
    private JTextField name;
    private JTextField surname;
    private JTextField phone;

    public RegistrateListener(JTextField login, JTextField password, JTextField name, JTextField surname, JTextField phone) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (!ExtJButton.class.equals(obj.getClass())) {
            System.out.println(this.getClass() + ": " + obj.getClass() + " instead of "
                    + ExtJButton.class);
            return;
        }
        final Controller controller = ((ExtJButton)obj).getController();
        RegistrationForm form = new RegistrationForm(
            login.getText(),
            password.getText(),
            name.getText(),
            surname.getText(),
            phone.getText()
        );
        controller.registrate(form);
    }
}
