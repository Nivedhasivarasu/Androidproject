/********************************************************************************************
 Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 Vestibulum commodo. Ut rhoncus gravida arcu.
 *******************************************************************************************/

package com.example.a17bit022;

public class UserIn {
    private String name;
    private String email;
    private String phno;
    private String college;
    private String cname;
    private String date;
    private String stucount;
    private String session;
    private String rollno;

    public UserIn() {
    }

    public UserIn(String name, String email, String phno, String college, String cname, String date, String stucount, String session, String rollno) {
        this.name = name;
        this.email = email;
        this.phno = phno;
        this.college = college;
        this.cname = cname;
        this.date = date;
        this.stucount = stucount;
        this.session = session;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStucount() {
        return stucount;
    }

    public void setStucount(String stucount) {
        this.stucount = stucount;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
}
