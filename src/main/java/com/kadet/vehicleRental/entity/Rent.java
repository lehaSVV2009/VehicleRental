package com.kadet.vehicleRental.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class Rent {

    private Occupier occupier;
    private Ship ship;
    private Long price;
    private Date startDate;
    private Date endDate;

    public Rent(Occupier occupier, Ship ship, Long price, Date startDate, Date endDate) {
        this.occupier = occupier;
        this.ship = ship;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Occupier getOccupier() {
        return occupier;
    }

    public Ship getShip() {
        return ship;
    }

    public Long getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "endDate=" + endDate +
                ", startDate=" + startDate +
                ", price=" + price +
                ", ship=" + ship +
                ", occupier=" + occupier +
                '}';
    }
}
