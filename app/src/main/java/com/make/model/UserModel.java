package com.make.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class UserModel implements Serializable {
    @PrimaryKey(autoGenerate = true) //khoa chinh tu dong render
    private int id;

    //@ColumnInfo (name = "user_name") //lam vay de tao cot. khong lam thi cot hien thi binh thuong nhu ben duoi. 2 cot là userName và address
    private String userName;
    private String dateOfBirth;
    private String address;
    private String email;
    private String passWord;

    public UserModel() {
    }

    public UserModel(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    public UserModel(int id, String userName, String dateOfBirth, String address, String email, String passWord) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
