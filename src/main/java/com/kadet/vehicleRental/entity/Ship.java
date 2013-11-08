package com.kadet.vehicleRental.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class Ship {

    private String code;
    private String name;
    private Long pricePerHour;
    private List<Comment> comments;

    public Ship(String code, String name, Long pricePerHour, List<Comment> comments) {
        this.code = code;
        this.name = name;
        this.pricePerHour = pricePerHour;
        this.comments = comments;
    }

    public boolean addComment (Comment comment) {
        return comments.add(comment);
    }

    public String getName() {
        return name;
    }

    public Long getPricePerHour() {
        return pricePerHour;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getCode() {
        return code;
    }

}
