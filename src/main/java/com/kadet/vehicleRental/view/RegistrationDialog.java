package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.listeners.CancelListener;
import com.kadet.vehicleRental.listeners.RegistrateListener;
import com.kadet.vehicleRental.util.Messages;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:19
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationDialog extends JDialog{

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    private final static int DEFAULT_TEXTFIELD_LENGTH = 20;

    private JLabel loginLabel;
    private JTextField login;
    private JLabel passwordLabel;
    private JTextField password;
    private JLabel nameLabel;
    private JTextField name;
    private JLabel surnameLabel;
    private JTextField surname;
    private JLabel phoneLabel;
    private JTextField phone;

    private ExtJButton registrateButton;
    private ExtJButton cancelButton;

    private ExtJPanel parent;

    public RegistrationDialog(ExtJPanel parent) {
        this.parent = parent;
        initialize();
        addComponents();
    }

    private void initialize () {
        setModal(true);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(6, 2));
    }

    private void addComponents() {
        loginLabel = new JLabel(Messages.LOGIN_LABEL);
        add(loginLabel);

        login = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(login);

        passwordLabel = new JLabel(Messages.PASSWORD_LABEL);
        add(passwordLabel);

        password = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(password);

        nameLabel = new JLabel(Messages.NAME_LABEL);
        add(nameLabel);

        name = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(name);

        surnameLabel = new JLabel(Messages.SURNAME_LABEL);
        add(surnameLabel);

        surname = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(surname);

        phoneLabel = new JLabel(Messages.PHONE_LABEL);
        add(phoneLabel);

        phone = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(phone);

        registrateButton = new ExtJButton(Messages.REGISTRATE_BUTTON, parent.getController());
        registrateButton.addActionListener(
                new RegistrateListener(
                        login,
                        password,
                        name,
                        surname,
                        phone
                )
        );
        add(registrateButton);

        cancelButton = new ExtJButton(Messages.CANCEL_BUTTON, parent.getController());
        cancelButton.addActionListener(
                new CancelListener(this)
        );
        add(cancelButton);
    }
}