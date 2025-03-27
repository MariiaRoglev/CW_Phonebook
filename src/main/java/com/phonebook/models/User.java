package com.phonebook.models;

public class User
{
   private String mail;
   private String pwd;

    public User setMail(String mail)
    {
        this.mail = mail;
        return this;
    }

    public User setPwd(String pwd)
    {
        this.pwd = pwd;
        return this;
    }

    public String getMail()
    {
        return mail;
    }

    public String getPwd()
    {
        return pwd;
    }
}