package com.example.edeleon8425.midterm_prog3210;

public class User {

    //variables
    int id;
    String uname;
    String comment;

    // Constructor with two parameters name and password
    public User(String uname, String comment) {
        this.uname = uname;
        this.comment = comment;
    }

    //getting id
    public int getId() {
        return id;
    }

    //setting id
    public void setId(int id) {
        this.id = id;
    }

    //getting name
    public String getName() {
        return uname;
    }

    //setting name
    public void setName(String uname) {
        this.uname = uname;
    }

    //getting password
    public String getComment() {
        return comment;
    }

    //setting password
    public void setComment(String comment) {
        this.comment = comment;
    }
}
