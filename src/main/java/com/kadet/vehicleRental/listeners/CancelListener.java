package com.kadet.vehicleRental.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public class CancelListener implements ActionListener{

    private JDialog dialog;

    public CancelListener(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
    }
}
