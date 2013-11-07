package com.kadet.vehicleRental;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.model.Model;
import com.kadet.vehicleRental.view.MainFrame;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 4:38
 * To change this template use File | Settings | File Templates.
 */
public final class VehicleRental {

    public static void startApplication() {

        final Controller controller = new Controller();
        final MainFrame mainFrame = new MainFrame(controller);
        final Model model = new Model(controller);
        controller.setMainFrame(mainFrame);
        controller.setModel(model);
        mainFrame.setVisible(true);
    }
}
