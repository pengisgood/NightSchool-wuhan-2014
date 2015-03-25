package org.nightschool.model;

public class Disk {
    private String name;
    private String imgUrl;
    private String description;
    private int number;
    private double price;

    public Disk(String name, String imgUrl, String description, int number, double price)
    {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.number = number;
        this.price = price;
    }

    public Disk() {

    }


    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
