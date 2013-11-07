package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.listeners.LogInListener;
import com.kadet.vehicleRental.listeners.OpenRegistrationDialogListener;
import com.kadet.vehicleRental.util.Messages;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:58
 * To change this template use File | Settings | File Templates.
 */
public class StartPanel extends ExtJPanel {

    private static final int defaultTextFieldLength = 20;

    private ExtJButton registrationButton;
    private JLabel loginLabel;
    private JTextField loginTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private ExtJButton loginButton;

    private Controller controller;
    private ExtJPanel parent;

    public StartPanel(ExtJPanel parent) {
        this.parent = parent;
        this.controller = parent.getController();
        initialize();
        addComponents();
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void addComponents () {
        registrationButton = new ExtJButton(Messages.REGISTRATION_BUTTON, controller);
        registrationButton.addActionListener(
                new OpenRegistrationDialogListener()
        );
        add(registrationButton);

        loginLabel = new JLabel(Messages.LOGIN_LABEL);
        add(loginLabel);

        loginTextField = new JTextField(defaultTextFieldLength);
        add(loginTextField);

        passwordLabel = new JLabel(Messages.PASSWORD_LABEL);
        add(passwordLabel);

        passwordTextField = new JTextField(defaultTextFieldLength);
        add(passwordTextField);

        loginButton = new ExtJButton(Messages.LOG_IN_BUTTON, controller);
        loginButton.addActionListener(
                new LogInListener(loginTextField, passwordTextField)
        );
        add(loginButton);
    }


    @Override
    public Controller getController() {
        return parent.getController();
    }
}
