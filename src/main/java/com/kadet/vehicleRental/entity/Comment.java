package com.kadet.vehicleRental.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Comment {

    private Occupier author;
    private String comment;

    public Comment(Occupier occupier, String comment) {
        this.author = occupier;
        this.comment = comment;
    }

    public Occupier getAuthor() {
        return author;
    }

    public String getAuthorName () {
        return author.getName();
    }

    public String getComment() {
        return comment;
    }
}
