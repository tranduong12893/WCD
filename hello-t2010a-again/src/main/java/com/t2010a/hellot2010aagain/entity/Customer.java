package com.t2010a.hellot2010aagain.entity;

import com.t2010a.hellot2010aagain.util.DateTimeHelper;

import java.time.LocalDateTime;

public class Customer {
    private String ID;
    private String Name;
    private String Phone;
    private String Image;
    private LocalDateTime Dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int Status;

    public Customer() {
    }

    public Customer(String ID, String name, String phone, String image, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Image = image;
        Dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        Status = status;
    }

    public Customer(String ID, String name, String phone, String image, LocalDateTime dob) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Image = image;
        Dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        Status = 1;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LocalDateTime getDob() {
        return Dob;
    }

    public void setDob(LocalDateTime dob) {
        Dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDobString() {
        if(this.Dob!= null){
            return DateTimeHelper.convertLocalDateTimeToString(this.Dob);
        }
        return "";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Image='" + Image + '\'' +
                ", Dob=" + Dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", Status=" + Status +
                '}';
    }
}
