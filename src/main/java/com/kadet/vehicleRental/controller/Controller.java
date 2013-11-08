package com.kadet.vehicleRental.controller;

import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Occupier;
import com.kadet.vehicleRental.entity.Ship;
import com.kadet.vehicleRental.model.Model;
import com.kadet.vehicleRental.util.Messages;
import com.kadet.vehicleRental.util.Validator;
import com.kadet.vehicleRental.view.MainFrame;
import com.kadet.vehicleRental.viewEntity.LogInForm;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;
import com.kadet.vehicleRental.viewEntity.RentForm;

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

    public void openRegistrationDialog() {
        mainFrame.openRegistrationDialog();
    }

    public void registrate(RegistrationForm form) {
        if (!Validator.validateRegistrationForm(form)) {
            mainFrame.showMessage(Messages.WRONG_INPUT_DATA);
            return;
        }
        boolean success = model.registrate(form);
        if (success) {
            mainFrame.showMessage(Messages.REGISTRATION_SUCCESS);
            mainFrame.closeRegistrationDialog();
        } else {
            mainFrame.showMessage(Messages.REGISTRATION_FAILED);
        }
    }

    public void logIn(LogInForm form) {
        if (!Validator.validateLogInForm(form)) {
            mainFrame.showMessage(Messages.WRONG_INPUT_DATA);
            return;
        }
        boolean success = model.logIn(form);
        if (success) {
            mainFrame.showMessage(Messages.LOG_IN_SUCCESS);
            mainFrame.setViewShipsPanelAsActivePanel(model.getShips());
            mainFrame.revalidate();
        } else {
            mainFrame.showMessage(Messages.LOG_IN_FAILED);
        }
    }

    public void addComment(String shipCode, String commentText) {
        if (validateShipAndOccupier(shipCode)) {
            Ship ship
                    = model.findShipByCode(shipCode);
            Occupier author
                    = model.getCurrentOccupier();
            Comment comment
                    = new Comment(author, commentText);
            boolean success = model.addComment(comment, ship);
            if (success) {
                mainFrame.setViewShipsPanelAsActivePanel(model.getShips());
                mainFrame.revalidate();
            } else {
                mainFrame.showMessage(Messages.COMMENT_SAVE_USER);
            }
        }
    }

    public void openRentDialog(String shipCode) {
        if (validateShipAndOccupier(shipCode)) {
            Ship ship
                    = model.findShipByCode(shipCode);
            mainFrame.openRentDialog(
                    shipCode,
                    model.getRentOfShip(ship)
            );
        }
    }

    public void showPrice (RentForm rentForm) {
        if (validateRentForm(rentForm)) {
            Ship ship = model.findShipByCode(rentForm.getShipCode());
            Long price = model.countPrice(
                    rentForm.getFrom(),
                    rentForm.getTo(),
                    ship);
            mainFrame.showShipPrice(String.valueOf(price), ship.getName());
        }
    }

    public void rent(RentForm rentForm) {
        if (validateRentForm(rentForm)) {
            boolean success = model.rent(rentForm);
            if (success) {
                mainFrame.showMessage(Messages.RENT_SUCCESS);
                mainFrame.closeRentDialog();
            } else {
                mainFrame.showMessage(Messages.SHIP_IS_ALSO_OCCUPIED);
            }
        }
    }

    private boolean validateRentForm(RentForm rentForm) {
        if (!Validator.validateRentForm(rentForm)) {
            mainFrame.showMessage(Messages.WRONG_INPUT_DATA);
            return false;
        }
        if (!validateShipAndOccupier(rentForm.getShipCode())) {
            return false;
        }
        return true;
    }

    private boolean validateShipAndOccupier (String shipCode) {
        return validateOccupier()
                && validateShip(shipCode);
    }

    private boolean validateShip (String shipCode) {
        if (!model.checkShip(shipCode)) {
            mainFrame.showMessage(Messages.FIND_SHIP_ERROR);
            return false;
        }
        return true;
    }

    private boolean validateOccupier () {
        if (!model.checkCurrentOccupier()) {
            mainFrame.showMessage(Messages.NOT_REGISTERED_USER);
            return false;
        }
        return true;
    }

    public void logOut () {
        if (validateOccupier()) {
            model.nullifyCurrentOccupier();
            mainFrame.setStartPanelAsActivePanel();
            mainFrame.revalidate();
        }
    }


    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
