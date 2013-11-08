package com.kadet.vehicleRental.model;

import com.kadet.vehicleRental.entity.Comment;
import com.kadet.vehicleRental.entity.Occupier;
import com.kadet.vehicleRental.entity.Rent;
import com.kadet.vehicleRental.entity.Ship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public class Storage {

    private List<Occupier> occupiers;
    private List<Ship> ships;
    private List<Rent> rents;

    public Storage() {
        occupiers = new ArrayList<Occupier>();
        ships = new ArrayList<Ship>();
        rents = new ArrayList<Rent>();
        fillStorage();
    }

    private void fillStorage () {
        Occupier occupier1 = new Occupier(
                "Alex",
                "Soroka",
                "37533652347825",
                "login",
                "pass"
        );
        Occupier occupier2 = new Occupier(
                "Evgen",
                "Mink",
                "3476553845",
                "login2",
                "pass2"
        );
        Occupier occupier3 = new Occupier(
                "Evgeniy",
                "Markushin",
                "9328759234",
                "login3",
                "pass3"
        );

        occupiers.add(occupier1);
        occupiers.add(occupier2);
        occupiers.add(occupier3);

        Comment comment1 = new Comment(
                occupier1,
                "good"
        );
        Comment comment2 = new Comment(
                occupier1,
                "nice"
        );
        Comment comment3 = new Comment(
                occupier2,
                "bad"
        );
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        Ship ship1 = new Ship(
                "#09sdf9",
                "ship1",
                (long)1,
                comments
        );

        Ship ship2 = new Ship(
                "#876sdfo9",
                "Ship2",
                (long)3,
                new ArrayList<Comment>()
        );

        ships.add(ship1);
        ships.add(ship2);


        Date dateTo1 = new Date();
        dateTo1.setTime(234234234);
        Date dateTo2 = new Date();
        dateTo2.setTime(438756234);
        Rent rent = new Rent(
                occupier1,
                ship1,
                ship1.getPricePerHour() * (dateTo2.getHours() - dateTo1.getHours()),
                dateTo1,
                dateTo2
        );
        rents.add(rent);
    }

    public List<Occupier> getOccupiers() {
        return occupiers;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Rent> getRents() {
        return rents;
    }


}

