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
 * Time: 3:09
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame extends JFrame {

    private final static int width = 600;
    private final static int height = 600;

    private MainPanel mainPanel;
    private Controller controller;

    public MainFrame(Controller controller) throws HeadlessException {
        this.controller = controller;
        initialize();
        addComponents();
    }

    private void initialize () {
        setMinimumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents () {
        mainPanel = new MainPanel(this);
        setStartPanelAsActivePanel();
        setContentPane(mainPanel);
    }

    public Controller getController() {
        return controller;
    }

    public void showMessage (String message) {
        mainPanel.showMessage(message);
    }

    public void openRegistrationDialog () {
        mainPanel.openRegistrationDialog();
    }

    public void closeRegistrationDialog () {
        mainPanel.closeRegistrationDialog();
    }

    public void setStartPanelAsActivePanel () {
        mainPanel.setStartPanelAsActivePanel();
    }

    public void setViewShipsPanelAsActivePanel (List<Ship> ships) {
        mainPanel.setViewShipsPanelAsActivePanel(ships);
    }

    public void openRentDialog (String shipCode, List<Rent> rents) {
        mainPanel.openRentDialog(shipCode, rents);
    }

    public void closeRentDialog () {
        mainPanel.closeRentDialog();
    }

    public void showShipPrice (String price, String shipName) {
        mainPanel.showShipPrice(price, shipName);
    }

}
