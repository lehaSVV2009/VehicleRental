package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Ship;
import com.kadet.vehicleRental.listeners.AddCommentListener;
import com.kadet.vehicleRental.listeners.RentListener;
import com.kadet.vehicleRental.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class ShipInfoPanel extends ExtJPanel {

    private static final int DEFAULT_TEXTFIELD_LENGTH = 20;

    private JLabel code;
    private JLabel name;
    private JLabel price;
    private List<CommentPanel> commentPanels;
    private JTextField addCommentTextField;
    private ExtJButton addCommentButton;
    private ExtJButton rentShipButton;

    private ExtJPanel parent;

    public ShipInfoPanel(ExtJPanel parent, Ship ship) {
        this.parent = parent;
        initialize();
        addComponents(ship);
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void addComponents (Ship ship) {
        code = new JLabel(ship.getCode());
        code.setVisible(false);
        add(code);

        name = new JLabel(ship.getName());
        add(name);

        price = new JLabel(String.valueOf(ship.getPricePerHour()));
        add(price);

        commentPanels = new ArrayList<CommentPanel>();
        for (Comment comment : ship.getComments()) {
            CommentPanel commentPanel = new CommentPanel(this, comment);
            add(commentPanel);
            commentPanels.add(commentPanel);
        }

        addCommentTextField = new JTextField(DEFAULT_TEXTFIELD_LENGTH);
        add(addCommentTextField);

        addCommentButton = new ExtJButton(Messages.ADD_COMMENT_BUTTON, parent.getController());
        addCommentButton.addActionListener(
                new AddCommentListener(code, addCommentTextField)
        );
        add(addCommentButton);

        rentShipButton = new ExtJButton(Messages.RENT_SHIP_BUTTON, parent.getController());
        rentShipButton.addActionListener(
                new RentListener(code)
        );
        add(rentShipButton);
    }

    @Override
    public Controller getController() {
        return parent.getController();
    }
}
