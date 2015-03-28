package org.nightschool.model;

public class Disk {
    private String name;
    private String category;
    private String imgurl;
    private String description;
    private int count;
    private double price;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Disk(String name, String category, String imgurl, String description, int count, double price)
    {
        this.name = name;
        this.category = category;
        this.imgurl = imgurl;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public Disk() {

    }

    public String getName() {
        return name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return name + " : " + category + " : " + imgurl + " : " + description + " : ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int hashCode() {
        return name.hashCode() + category.hashCode() + imgurl.hashCode() + description.hashCode() + count + Double.valueOf(price).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if(object != null && object instanceof Disk) {
            Disk disk = (Disk)object;
            result = this.name.equals(disk.getName()) &&
                        this.category.equals(disk.getCategory()) &&
                        this.imgurl.equals(disk.getImgurl()) &&
                        this.description.equals(disk.getDescription()) &&
                        this.count == disk.getCount() &&
                        this.price == disk.getPrice();
        }
        return result;
    }
}
