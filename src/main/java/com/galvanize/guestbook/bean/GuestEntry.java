package com.galvanize.guestbook.bean;

public class GuestEntry {

    private int id;
    private String name;
    private String comments;

    public GuestEntry() {
    }

    public GuestEntry(int id, String name, String comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
