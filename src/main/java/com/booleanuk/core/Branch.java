package com.booleanuk.core;

public class Branch {
    private String code;
    private String country;
    private String city;

    public Branch(String code, String country, String city) {
        this.code = code;
        this.country = country;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
