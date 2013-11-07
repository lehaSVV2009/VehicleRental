package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.util.Messages;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class OccupiedPanel extends JPanel {

    private JLabel fromLabel;
    private JLabel from;
    private JLabel toLabel;
    private JLabel to;

    public OccupiedPanel(Rent rent) {
        initialize();
        addComponents(rent);
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void addComponents (Rent rent) {
        fromLabel = new JLabel(Messages.FROM_LABEL);
        add(fromLabel);

        from = new JLabel(rent.getStartDate().toString());
        add(from);

        toLabel = new JLabel(Messages.TO_LABEL);
        add(toLabel);

        to = new JLabel(rent.getEndDate().toString());
        add(to);
    }
}
