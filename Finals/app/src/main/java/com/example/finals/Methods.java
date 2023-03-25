package com.example.finals;

public class Methods {
    private String schoolID;
    private String schoolGmail;
    private String userName;
    private String password;

    public void SetSchoolId(String pid){
    this.schoolID = pid;
    }

    public String GetSchoolID(){
        return schoolID;
    }

    public void SetSchoolGmail(String pgmail){
        this.schoolGmail = pgmail;
    }

    public String GetSchoolGmail(){
        return schoolGmail;
    }

    public void SetUserName(String pname){
        this.userName = pname;
    }

    public String GetName(){
        return userName;
    }

    public void SetPass(String ppass){
        this.password = ppass;
    }

    public String GetPassword(){
        return password;
    }




}
