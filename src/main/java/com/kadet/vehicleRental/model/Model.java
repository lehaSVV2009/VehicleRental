package com.kadet.vehicleRental.model;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Occupier;
import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.entity.Ship;
import com.kadet.vehicleRental.util.Validator;
import com.kadet.vehicleRental.viewEntity.LogInForm;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 4:40
 * To change this template use File | Settings | File Templates.
 */
public class Model {

    private Controller controller;

    private Occupier currentOccupier;

    private Storage storage = new Storage();

    public Model(Controller controller) {
        this.controller = controller;
    }

    public boolean registrate (RegistrationForm form) {
        boolean result;
        if (Validator.validRegistrationForm(form)) {

            List<Occupier> occupiers
                    = storage.getOccupiers();
            if (checkLogin(form.getLogin(), occupiers)) {

                Occupier occupier = new Occupier(
                        form.getName(),
                        form.getSurname(),
                        form.getPhone(),
                        form.getLogin(),
                        form.getPassword()
                );
                occupiers.add(occupier);
                result = true;

            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    private boolean checkLogin (String login, List<Occupier> occupiers) {
        for(Occupier occupier : occupiers) {
            if (login.equals(occupier.getLogin())) {
                return false;
            }
        }
        return true;
    }

    public boolean logIn (LogInForm form) {
        boolean result = false;
        if (Validator.validLogInForm(form)) {
            List<Occupier> occupiers = storage.getOccupiers();
            for(Occupier occupier : occupiers) {
                if (checkLoginAndPassword(form, occupier)) {
                    result = true;
                    currentOccupier = occupier;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    private boolean checkLoginAndPassword (LogInForm logInForm, Occupier occupier) {
        return logInForm.getLogin().equals(occupier.getLogin())
                && logInForm.getPassword().equals(occupier.getPassword());
    }

    public Ship findShipByCode (String code) {
        List<Ship> ships = storage.getShips();
        for (Ship ship : ships) {
            if (code.equals(ship.getCode())) {
                return ship;
            }
        }
        return null;
    }

    public boolean addComment (Comment comment, Ship ship) {
        return ship.addComment(comment);
    }

    public List<Rent> getRentOfShip (Ship ship) {
        List<Rent> rentsOfCurrentShip = new ArrayList<Rent>();
        List<Rent> rents = storage.getRents();
        for (Rent rent : rents) {
            if (ship.equals(rent.getShip())) {
                rentsOfCurrentShip.add(rent);
            }
        }
        return rentsOfCurrentShip;
    }

    public List<Ship> getShips () {
        return storage.getShips();
    }

    public Occupier getCurrentOccupier() {
        return currentOccupier;
    }
}