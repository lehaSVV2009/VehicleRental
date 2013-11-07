package com.kadet.vehicleRental.listeners;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.view.ExtJButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
public class AddCommentListener implements ActionListener {

    private JLabel shipCode;
    private JTextField comment;

    public AddCommentListener(JLabel shipCode, JTextField comment) {
        this.shipCode = shipCode;
        this.comment = comment;
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
        controller.addComment(shipCode.getText(), comment.getText());
    }
}
