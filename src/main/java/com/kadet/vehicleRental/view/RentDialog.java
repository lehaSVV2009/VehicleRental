package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public class RentDialog extends JDialog {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    private final static int DEFAULT_TEXTFIELD_LENGTH = 20;


    private JLabel shipCode;
    private List<OccupiedPanel> occupiedPanels;
    private ExtJButton rentButton;
    private ExtJButton cancelButton;

    private ExtJPanel parent;

    public RentDialog(ExtJPanel parent, String shipCode, List<Rent> rents) {
        this.parent = parent;
        initialize();
        addComponents(shipCode, rents);
    }

    private void initialize () {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void addComponents (String code, List<Rent> rents) {

        shipCode = new JLabel(code);
        add(shipCode);

        occupiedPanels = new ArrayList<OccupiedPanel>();
        for (Rent rent : rents) {
            OccupiedPanel panel = new OccupiedPanel(rent);
            occupiedPanels.add(panel);
        }

        for (OccupiedPanel panel : occupiedPanels) {
            add(panel);
        }

        rentButton = new ExtJButton(Messages.RENT_BUTTON, parent.getController());
        add(rentButton);

        cancelButton = new ExtJButton(Messages.CANCEL_BUTTON, parent.getController());
        add(cancelButton);
    }
}
