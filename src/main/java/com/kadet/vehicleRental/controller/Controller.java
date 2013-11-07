package com.kadet.vehicleRental.controller;

import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Occupier;
import com.kadet.vehicleRental.entity.Ship;
import com.kadet.vehicleRental.model.Model;
import com.kadet.vehicleRental.util.Messages;
import com.kadet.vehicleRental.view.MainFrame;
import com.kadet.vehicleRental.viewEntity.LogInForm;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 3:26
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    private MainFrame mainFrame;
    private Model model;

    public void openRegistrationDialog () {
        mainFrame.openRegistrationDialog();
    }

    public void registrate (RegistrationForm form) {
        boolean success = model.registrate(form);
        if (success) {
            mainFrame.showMessage(Messages.REGISTRATION_SUCCESS);
            mainFrame.closeRegistrationDialog();
        } else {
            mainFrame.showMessage(Messages.REGISTRATION_FAILED);
        }
    }

    public void logIn (LogInForm form) {
        boolean success = model.logIn(form);
        if (success) {
            mainFrame.showMessage(Messages.LOG_IN_SUCCESS);
            mainFrame.setViewShipsPanelAsActivePanel(model.getShips());
            mainFrame.revalidate();
        } else {
            mainFrame.showMessage(Messages.LOG_IN_FAILED);
        }
    }

    public void addComment (String shipCode, String commentText) {
        boolean success;
        Ship ship = model.findShipByCode(shipCode);
        if (ship == null) {
            mainFrame.showMessage(Messages.FIND_SHIP_ERROR);
            return;
        }
        Occupier author = model.getCurrentOccupier();
        if (author == null) {
            mainFrame.showMessage(Messages.NOT_REGISTERED_USER);
            return;
        }
        Comment comment = new Comment(author, commentText);
        success = model.addComment(comment, ship);
        if (success) {
            mainFrame.setViewShipsPanelAsActivePanel(model.getShips());
            mainFrame.revalidate();
        } else {
            mainFrame.showMessage(Messages.COMMENT_SAVE_USER);
        }
    }

    public void openRentDialog (String shipCode) {
        Ship ship = model.findShipByCode(shipCode);
        if (ship == null) {
            mainFrame.showMessage(Messages.FIND_SHIP_ERROR);
            return;
        }
        Occupier occupier = model.getCurrentOccupier();
        if (occupier == null) {
            mainFrame.showMessage(Messages.NOT_REGISTERED_USER);
            return;
        }
        mainFrame.openRentDialog(
                shipCode,
                model.getRentOfShip(ship)
        );
    }

    public void setMainFrame (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setModel (Model model) {
        this.model = model;
    }

}
