package com.kadet.vehicleRental.listeners;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.view.ExtJButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 08.11.13
 * Time: 3:05
 * To change this template use File | Settings | File Templates.
 */
public class LogOutListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (!ExtJButton.class.equals(obj.getClass())) {
            System.out.println(this.getClass() + ": " + obj.getClass() + " instead of "
                    + ExtJButton.class);
            return;
        }
        final Controller controller = ((ExtJButton)obj).getController();
        controller.logOut();
    }
}
