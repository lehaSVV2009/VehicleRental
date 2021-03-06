package com.kadet.vehicleRental.listeners;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.util.Transformer;
import com.kadet.vehicleRental.view.ExtJButton;
import com.kadet.vehicleRental.view.TimePanel;
import com.kadet.vehicleRental.viewEntity.RentForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class RentListener implements ActionListener{

    protected JLabel shipCode;
    protected TimePanel fromTimePanel;
    protected TimePanel toTimePanel;

    public RentListener(JLabel shipCode, TimePanel fromTimePanel, TimePanel toTimePanel) {
        this.shipCode = shipCode;
        this.fromTimePanel = fromTimePanel;
        this.toTimePanel = toTimePanel;
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
        RentForm rentForm = new RentForm(
                shipCode.getText(),
                Transformer.dateFromTimePanel(fromTimePanel),
                Transformer.dateFromTimePanel(toTimePanel)
        );
        controller.rent(rentForm);
    }


}
