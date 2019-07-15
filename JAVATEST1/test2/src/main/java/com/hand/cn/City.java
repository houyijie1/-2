package com.hand.cn;

public class City {
    private Integer country_id;
    private Integer city_id;
    private String  name;

    public City(Integer country_id, Integer city_id, String name) {
        this.country_id = country_id;
        this.city_id = city_id;
        this.name = name;
    }

    public City() {
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
