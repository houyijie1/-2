package com.hand.cn;

public class Country {
    private  Integer country_id;
    private  String  country;
    private  String  update;

    public Country(Integer country_id, String country, String update) {
        this.country_id = country_id;
        this.country = country;
        this.update = update;
    }

    public Country() {
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
