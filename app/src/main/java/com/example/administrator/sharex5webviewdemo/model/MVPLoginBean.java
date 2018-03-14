package com.example.administrator.sharex5webviewdemo.model;



public class MVPLoginBean {

    private String userName;
    private String passWord;

    public MVPLoginBean() {
        super();
    }

    public MVPLoginBean(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "MVPLoginBean [userName=" + userName + ", passWord=" + passWord
                + "]";
    }
}
