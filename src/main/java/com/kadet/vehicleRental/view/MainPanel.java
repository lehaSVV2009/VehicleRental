package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.entity.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:11
 * To change this template use File | Settings | File Templates.
 */
public class MainPanel extends ExtJPanel {

    private MainFrame parent;

    private RegistrationDialog registrationDialog;
    private RentDialog rentDialog;

    public MainPanel(MainFrame parent) {
        this.parent = parent;
        initialize();
    }

    private void initialize () {
        setLayout(new BorderLayout());
    }

    public void setStartPanelAsActivePanel () {
        setActivePanel(new StartPanel(this));
    }

    public void setViewShipsPanelAsActivePanel (List<Ship> ships) {
        setActivePanel(new ViewShipsPanel(this, ships));
    }

    private void setActivePanel(ExtJPanel activePanel) {
        removeAll();
        add(activePanel);
    }

    public void openRegistrationDialog () {
        if (registrationDialog == null) {
            registrationDialog = new RegistrationDialog(this);
        }
        registrationDialog.setVisible(true);
    }

    public void closeRegistrationDialog () {
        registrationDialog.setVisible(false);
    }

    public void openRentDialog (String shipCode, List<Rent> rents) {
        rentDialog = new RentDialog(this, shipCode, rents);
        rentDialog.setVisible(true);
    }

    public void closeRentDialog () {
        rentDialog.setVisible(false);
    }


    public void showMessage (String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public Controller getController () {
        return parent.getController();
    }

}
