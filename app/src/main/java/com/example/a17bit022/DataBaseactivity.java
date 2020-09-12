/********************************************************************************************
 Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 Vestibulum commodo. Ut rhoncus gravida arcu.
 *******************************************************************************************/

package com.example.a17bit022;

public class DataBaseactivity {
    private String databaseactivityusername;
    private String databaseactivityuseremail;
    private String databaseactivityusercollege;
    private String databaseactivityuserphno;
    private String databaseactivityuserrollno;

    public DataBaseactivity() {
    }

    public DataBaseactivity(String databaseactivityusername, String databaseactivityuseremail, String databaseactivityusercollege, String databaseactivityuserphno, String databaseactivityuserrollno) {
        this.databaseactivityusername = databaseactivityusername;
        this.databaseactivityuseremail = databaseactivityuseremail;
        this.databaseactivityusercollege = databaseactivityusercollege;
        this.databaseactivityuserphno = databaseactivityuserphno;
        this.databaseactivityuserrollno = databaseactivityuserrollno;
    }

    public String getDatabaseactivityusername() {
        return databaseactivityusername;
    }

    public void setDatabaseactivityusername(String databaseactivityusername) {
        this.databaseactivityusername = databaseactivityusername;
    }

    public String getDatabaseactivityuseremail() {
        return databaseactivityuseremail;
    }

    public void setDatabaseactivityuseremail(String databaseactivityuseremail) {
        this.databaseactivityuseremail = databaseactivityuseremail;
    }

    public String getDatabaseactivityusercollege() {
        return databaseactivityusercollege;
    }

    public void setDatabaseactivityusercollege(String databaseactivityusercollege) {
        this.databaseactivityusercollege = databaseactivityusercollege;
    }

    public String getDatabaseactivityuserphno() {
        return databaseactivityuserphno;
    }

    public void setDatabaseactivityuserphno(String databaseactivityuserphno) {
        this.databaseactivityuserphno = databaseactivityuserphno;
    }

    public String getDatabaseactivityuserrollno() {
        return databaseactivityuserrollno;
    }

    public void setDatabaseactivityuserrollno(String databaseactivityuserrollno) {
        this.databaseactivityuserrollno = databaseactivityuserrollno;
    }
}
