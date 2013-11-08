package com.kadet.vehicleRental.model;

import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Occupier;
import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.entity.Ship;
import com.kadet.vehicleRental.util.Validator;
import com.kadet.vehicleRental.viewEntity.LogInForm;
import com.kadet.vehicleRental.viewEntity.RegistrationForm;
import com.kadet.vehicleRental.viewEntity.RentForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 4:40
 * To change this template use File | Settings | File Templates.
 */
public class Model {

    private Occupier currentOccupier;

    private Storage storage = new Storage();

    public Model() {
    }

    public boolean registrate(RegistrationForm form) {
        boolean result;
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
        return result;
    }

    private boolean checkLogin(String login, List<Occupier> occupiers) {
        for (Occupier occupier : occupiers) {
            if (login.equals(occupier.getLogin())) {
                return false;
            }
        }
        return true;
    }

    public boolean logIn(LogInForm form) {
        boolean result = false;
        List<Occupier> occupiers = storage.getOccupiers();
        for (Occupier occupier : occupiers) {
            if (checkLoginAndPassword(form, occupier)) {
                result = true;
                currentOccupier = occupier;
            }
        }
        return result;
    }

    private boolean checkLoginAndPassword(LogInForm logInForm, Occupier occupier) {
        return logInForm.getLogin().equals(occupier.getLogin())
                && logInForm.getPassword().equals(occupier.getPassword());
    }

    public Ship findShipByCode(String code) {
        List<Ship> ships = storage.getShips();
        for (Ship ship : ships) {
            if (code.equals(ship.getCode())) {
                return ship;
            }
        }
        return null;
    }

    public boolean addComment(Comment comment, Ship ship) {
        return ship.addComment(comment);
    }

    public List<Rent> getRentOfShip(Ship ship) {
        List<Rent> rentsOfCurrentShip = new ArrayList<Rent>();
        List<Rent> rents = storage.getRents();
        for (Rent rent : rents) {
            if (ship.equals(rent.getShip())) {
                rentsOfCurrentShip.add(rent);
            }
        }
        return rentsOfCurrentShip;
    }

    public long countPrice (Date from, Date to, Ship ship) {
        long money = 1;
        money += (to.getTime() - from.getTime()) / 1000 / 60 / 60;
        money *= ship.getPricePerHour();
        return money;
    }

    public boolean checkShip (String shipCode) {
        Ship ship = findShipByCode(shipCode);
        return ship != null;
    }

    public boolean checkCurrentOccupier () {
        return currentOccupier != null;
    }

    public boolean rent(RentForm rentForm) {
        boolean result = false;
        Ship ship = findShipByCode(rentForm.getShipCode());
        Date from = rentForm.getFrom();
        Date to = rentForm.getTo();
        List<Rent> rents = getRentOfShip(ship);
        boolean inAnotherRent = false;
        for (Rent rent : rents) {
            if (!checkDateInAnotherRent(to, from, rent)) {
                inAnotherRent = true;
            }
        }
        if (!inAnotherRent) {
            Rent rent = new Rent(
                    currentOccupier,
                    ship,
                    countPrice(from, to, ship),
                    from,
                    to
            );
            System.out.println(rent);
            rents.add(rent);
            result = true;
        }
        return result;
    }

    private boolean checkDateInAnotherRent (Date to, Date from, Rent anotherRent) {
        Date anotherFrom = anotherRent.getStartDate();
        Date anotherTo = anotherRent.getEndDate();
        return (to.before(anotherFrom) && from.before(anotherFrom))
                || (to.after(anotherTo) && from.after(anotherTo));
    }

    public List<Ship> getShips() {
        return storage.getShips();
    }

    public Occupier getCurrentOccupier() {
        return currentOccupier;
    }

    public void nullifyCurrentOccupier () {
        currentOccupier = null;
    }
}