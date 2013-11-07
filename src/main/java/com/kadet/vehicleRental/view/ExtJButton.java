package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:25
 * To change this template use File | Settings | File Templates.
 */
public class ExtJButton extends JButton implements ExtJComponent{

    private final Controller controller;

    public ExtJButton(final String buttonText, final Controller controller) {
        super(buttonText);
        this.controller = controller;
    }

    @Override
    public Controller getController () {
        return controller;
    }
}