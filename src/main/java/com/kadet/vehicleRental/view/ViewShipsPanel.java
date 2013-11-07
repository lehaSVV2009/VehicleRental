package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:59
 * To change this template use File | Settings | File Templates.
 */
public class ViewShipsPanel extends ExtJPanel {

    private ExtJPanel parent;
    private List<ShipInfoPanel> shipPanels;

    public ViewShipsPanel(ExtJPanel parent, List<Ship> ships) {
        this.parent = parent;
        initialize();
        addComponents(ships);
    }

    private void initialize() {
        setLayout(new FlowLayout());
    }

    private void addComponents(List<Ship> ships) {

        shipPanels = new ArrayList<ShipInfoPanel>();
        for (Ship ship : ships) {
            ShipInfoPanel shipInfoPanel = new ShipInfoPanel(
                    this,
                    ship
            );
            shipPanels.add(shipInfoPanel);
        }

        for (ShipInfoPanel shipPanel : shipPanels) {
            add(shipPanel);
        }
    }

    @Override
    public Controller getController() {
        return parent.getController();
    }
}
