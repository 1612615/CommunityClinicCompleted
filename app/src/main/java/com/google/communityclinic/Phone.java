package com.google.communityclinic;

public class Phone {

    private String phonenumber;

    public Phone() {
    }

    public Phone(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhone(){return phonenumber;}

    public void setPhone(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    @Override
    public String toString(){
        return"Phone number " + phonenumber;
    }
}
