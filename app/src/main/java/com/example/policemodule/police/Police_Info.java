package com.example.policemodule.police;

import android.widget.ImageView;

public class Police_Info
{
    private int image;
    private String location,policestation,address,phno;

    public Police_Info(int image, String location, String policestation, String address, String phno) {
        this.image = image;
        this.location = location;
        this.policestation = policestation;
        this.address = address;
        this.phno = phno;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPolicestation() {
        return policestation;
    }

    public void setPolicestation(String policestation) {
        this.policestation = policestation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
