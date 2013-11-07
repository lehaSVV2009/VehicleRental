package com.kadet.vehicleRental.listeners;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.view.ExtJButton;
import com.kadet.vehicleRental.viewEntity.LogInForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class LogInListener implements ActionListener {

    private JTextField login;
    private JTextField password;

    public LogInListener(JTextField login, JTextField password) {
        this.login = login;
        this.password = password;
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
        LogInForm form = new LogInForm(
                login.getText(),
                password.getText()
        );
        controller.logIn(form);
    }
}
