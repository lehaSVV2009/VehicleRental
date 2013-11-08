package com.kadet.vehicleRental.viewEntity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 08.11.13
 * Time: 0:36
 * To change this template use File | Settings | File Templates.
 */
public class RentForm {

    private String shipCode;
    private Date from;
    private Date to;

    public RentForm(String shipCode, Date from, Date to) {
        this.shipCode = shipCode;
        this.from = from;
        this.to = to;
    }

    public String getShipCode() {
        return shipCode;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "RentForm{" +
                "shipCode='" + shipCode + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
