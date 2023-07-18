package com.booleanuk.extension;

public class Branch {
    private String code;
    private String Address;

    public Branch(String code, String address) {
        this.code = code;
        Address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
