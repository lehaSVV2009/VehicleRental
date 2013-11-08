package com.kadet.vehicleRental.util;

import com.kadet.vehicleRental.view.TimePanel;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 08.11.13
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public final class Transformer {

    public static Date dateFromTimePanel (TimePanel timePanel) {
        Date date = new Date();
        date.setYear(timePanel.getYear());
        date.setMonth(timePanel.getMonth());
        date.setDate(timePanel.getDay());
        date.setHours(timePanel.getHour());
        date.setMinutes(timePanel.getMinute());
        return date;
    }

}
