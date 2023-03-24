package com.example.finals;

public class PublicMethods {
    private String userID;
    private String userSchoolMail;
    private String userName;
    private String userPass;

    public void SetUserID( String pID){
        this.userID = pID;
    }

    public String GetUserID(){
        return userID;
    }

    public void SetUserSchoolMail( String pSchoolMail){
        this.userSchoolMail = pSchoolMail;
    }

    public String GetUserSchoolMail(){
        return userSchoolMail;
    }

    public void SetUserName( String pName){
        this.userName = pName;
    }

    public String GetUserName(){
        return userName;
    }

    public void SetUserPass( String pPass){
        this.userPass = pPass;
    }

    public String GetUserPass(){
        return userPass;
    }


}
