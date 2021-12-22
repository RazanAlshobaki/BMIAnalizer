package com.example.myapplication;

public class Food {
    private int img;

    public Food(int img, String name, String type, String calory) {
        this.img = img;
        this.name = name;
        this.type = type;
        this.calory = calory;
    }

    private String name, type, calory;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCalory() {
        return calory;
    }

    public void setCalory(String calory) {
        this.calory = calory;
    }

    public Food(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
