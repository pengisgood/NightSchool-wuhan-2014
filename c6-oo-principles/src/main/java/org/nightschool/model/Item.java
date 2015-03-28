package org.nightschool.model;

public class Item {
    private int id;
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


    public Item(String name, String category, String imgurl, String description, int count, double price)
    {
        this.name = name;
        this.category = category;
        this.imgurl = imgurl;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public Item() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int hashCode() {
        return name.hashCode() + category.hashCode() + imgurl.hashCode() + description.hashCode() + count + Double.valueOf(price).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if(object != null && object instanceof Item) {
            Item item = (Item)object;
            result = this.name.equals(item.getName()) &&
                        this.category.equals(item.getCategory()) &&
                        this.imgurl.equals(item.getImgurl()) &&
                        this.description.equals(item.getDescription()) &&
                        this.count == item.getCount() &&
                        this.price == item.getPrice();
        }
        return result;
    }
}
