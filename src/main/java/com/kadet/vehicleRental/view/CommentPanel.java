package com.kadet.vehicleRental.view;

import com.kadet.vehicleRental.controller.Controller;
import com.kadet.vehicleRental.entity.Comment;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 07.11.13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class CommentPanel extends ExtJPanel{

    private JLabel authorLabel;
    private JLabel commentLabel;

    private ExtJPanel parent;

    public CommentPanel(ExtJPanel parent, Comment comment) {
        this.parent = parent;
        initialize();
        addComponents(comment);
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void addComponents (Comment comment) {
        authorLabel = new JLabel(comment.getAuthorName());
        add(authorLabel);

        commentLabel = new JLabel(comment.getComment());
        add(commentLabel);
    }

    @Override
    public Controller getController() {
        return parent.getController();
    }
}
