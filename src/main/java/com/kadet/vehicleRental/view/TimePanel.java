package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.util.Data;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 08.11.13
 * Time: 0:25
 * To change this template use File | Settings | File Templates.
 */
public class TimePanel extends ExtJPanel{

    private ExtJPanel parent;

    private JLabel label;
    private JComboBox<String> day;
    private JComboBox<String> month;
    private JComboBox<String> year;
    private JComboBox<String> hour;
    private JComboBox<String> minute;

    public TimePanel(ExtJPanel parent, String title) {
        this.parent = parent;
        initialize();
        addComponents(title);
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void addComponents (String title) {
        
        label = new JLabel(title);
        add(label);

        day = new JComboBox<String>();
        add(day);

        month = new JComboBox<String>();
        add(month);

        year = new JComboBox<String>();
        add(year);

        hour = new JComboBox<String>();
        add(hour);

        minute = new JComboBox<String>();
        add(minute);

        fillComboboxPanel(year, month, day, hour, minute);

    }

    private void fillComboboxPanel (JComboBox<String> year, JComboBox<String> month, JComboBox<String> day, JComboBox<String> hour, JComboBox<String> minute) {

        for (String yearText : Data.YEARS) {
            year.addItem(yearText);
        }

        for (String monthText : Data.MONTHES) {
            month.addItem(monthText);
        }

        for (int i = 1; i <= 31; ++i) {
            day.addItem(String.valueOf(i));
        }

        for (int i = 0; i <= 23; ++i) {
            hour.addItem(String.valueOf(i));
        }

        for (String minuteText : Data.MINUTES) {
            minute.addItem(minuteText);
        }

    }

    public Integer getDay () {
        return Integer.parseInt((String)day.getSelectedItem());
    }

    public Integer getYear () {
        return Integer.parseInt((String)year.getSelectedItem());
    }

    public Integer getMonth () {
        return month.getSelectedIndex() + 1;
    }

    public Integer getHour () {
        return Integer.parseInt((String)hour.getSelectedItem());
    }

    public Integer getMinute () {
        return Integer.parseInt((String)minute.getSelectedItem());
    }


    @Override
    public Controller getController() {
        return parent.getController();
    }
}
