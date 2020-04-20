/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class Digital {

    private int id;
    private String title;
    private String image;
    private String notes;
    private String author;
    private Timestamp date;
    private String shortNotes;

    public Digital() {
    }

    public Digital(int id, String title, String image, String notes, String author, Timestamp date, String shortNotes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.notes = notes;
        this.author = author;
        this.date = date;
        this.shortNotes = shortNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImagePath() throws NamingException {
        return new config.Config().getConfigValue("image") + "/" + image;
    }

    public String getShortNotes() {
        return shortNotes;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDateFormat() {
        return new SimpleDateFormat("MMM dd yyyy - h:mm").format(this.date) + new SimpleDateFormat("a").format(this.date).toLowerCase();
    }

    public void setShortNotes(String shortNotes) {
        this.shortNotes = shortNotes;
    }
}
